package com.nathan.camistry.repository

import com.google.firebase.firestore.FirebaseFirestore

class ActionRepository {
    private val db = FirebaseFirestore.getInstance()

    fun likeUser(currentUserId: String, targetUserId: String, onResult: (isMatch: Boolean) -> Unit) {
        db.collection("user_actions")
            .document(currentUserId)
            .collection("likes")
            .document(targetUserId)
            .set(mapOf("timestamp" to System.currentTimeMillis()))
            .addOnSuccessListener {
                db.collection("user_actions")
                    .document(targetUserId)
                    .collection("likes")
                    .document(currentUserId)
                    .get()
                    .addOnSuccessListener { doc ->
                        val isMatch = doc.exists()
                        if (isMatch) {
                            saveMatch(currentUserId, targetUserId)
                        }
                        onResult(isMatch)
                    }
                    .addOnFailureListener { onResult(false) }
            }
            .addOnFailureListener { onResult(false) }
    }

    fun passUser(currentUserId: String, targetUserId: String, onResult: (Boolean) -> Unit) {
        db.collection("user_actions")
            .document(currentUserId)
            .collection("passes")
            .document(targetUserId)
            .set(mapOf("timestamp" to System.currentTimeMillis()))
            .addOnSuccessListener { onResult(true) }
            .addOnFailureListener { onResult(false) }
    }

    fun saveMatch(userA: String, userB: String) {
        val matchData = mapOf("userId" to userB, "timestamp" to System.currentTimeMillis())
        db.collection("user_matches").document(userA)
            .collection("matches").document(userB).set(matchData)
        db.collection("user_matches").document(userB)
            .collection("matches").document(userA).set(matchData)
    }
}