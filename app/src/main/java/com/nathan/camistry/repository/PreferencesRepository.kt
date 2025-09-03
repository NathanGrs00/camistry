package com.nathan.camistry.repository

import com.google.firebase.firestore.FirebaseFirestore
import com.nathan.camistry.model.DiscoverPreferences

class PreferencesRepository {
    private val db = FirebaseFirestore.getInstance()

    fun getPreferences(userId: String, onResult: (DiscoverPreferences?) -> Unit) {
        db.collection("preferences")
            .document(userId)
            .get()
            .addOnSuccessListener { doc ->
                val preferences = doc.toObject(DiscoverPreferences::class.java)
                onResult(preferences)
            }
            .addOnFailureListener {
                onResult(null)
            }
    }
}