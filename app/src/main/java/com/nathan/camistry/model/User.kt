package com.nathan.camistry.model

import android.location.Location

class User(
    val id: String,
    val firstName: String,
    val lastName: String,
    val age: Int,
    val gender: String,
    val location: Location,
    val interests: List<String>,
    val email: String,
    val password: String,
    val photos: List<String>
)