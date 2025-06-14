package com.nathan.camistry.repository

import com.google.firebase.auth.FirebaseAuth

class LoginRepository {
    private val auth: FirebaseAuth = FirebaseAuth.getInstance()

    fun login(email: String, password: String, callback: (Boolean, String?) -> Unit) {
        auth.signInWithEmailAndPassword(email, password)
            .addOnCompleteListener { task ->
                if (task.isSuccessful) {
                    callback(true, null)
                } else {
                    callback(false, task.exception?.message)
                }
            }
    }
}