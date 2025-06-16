package com.nathan.camistry.repository

import com.google.firebase.firestore.FirebaseFirestore
import com.nathan.camistry.model.User

class UserRepository {
    private val db = FirebaseFirestore.getInstance()
    fun getUser(userId: String, onResult: (User?) -> Unit) {
        db.collection("users")
            .document(userId)
            .get()
            .addOnSuccessListener { doc ->
                val user = doc.toObject(User::class.java)
                onResult(user)
            }
            .addOnFailureListener {
                onResult(null)
            }
    }

    fun updateUser(user: User, onResult: (Boolean) -> Unit) {
        db.collection("users")
            .document(user.id)
            .set(user)
            .addOnSuccessListener {
                onResult(true)
            }
            .addOnFailureListener {
                onResult(false)
            }
    }

    fun deleteUser(userId: String, onResult: (Boolean) -> Unit) {
        db.collection("users")
            .document(userId)
            .delete()
            .addOnSuccessListener {
                onResult(true)
            }
            .addOnFailureListener {
                onResult(false)
            }
    }
}