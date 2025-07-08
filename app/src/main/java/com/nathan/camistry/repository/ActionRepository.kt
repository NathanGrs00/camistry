package com.nathan.camistry.repository

import com.google.firebase.firestore.FirebaseFirestore

class ActionRepository {
    private val db = FirebaseFirestore.getInstance()

    // Called when currentUser likes targetUser
    fun likeUser(currentUserId: String, targetUserId: String, onResult: (isMatch: Boolean) -> Unit) {
        // Save the like
        db.collection("user_actions")
            .document(currentUserId)
            .collection("likes")
            .document(targetUserId)
            .set(mapOf("timestamp" to System.currentTimeMillis()))
            .addOnSuccessListener {
                // Check if targetUser also liked currentUser
                db.collection("user_actions")
                    .document(targetUserId)
                    .collection("likes")
                    .document(currentUserId)
                    .get()
                    .addOnSuccessListener { doc ->
                        onResult(doc.exists())
                    }
                    .addOnFailureListener { onResult(false) }
            }
            .addOnFailureListener { onResult(false) }
    }

    // Called when currentUser passes on targetUser
    fun passUser(currentUserId: String, targetUserId: String, onResult: (Boolean) -> Unit) {
        db.collection("user_actions")
            .document(currentUserId)
            .collection("passes")
            .document(targetUserId)
            .set(mapOf("timestamp" to System.currentTimeMillis()))
            .addOnSuccessListener { onResult(true) }
            .addOnFailureListener { onResult(false) }
    }
}