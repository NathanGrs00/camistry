package com.nathan.camistry.model

import android.location.Location

data class User(
    val id: String = "",
    val firstName: String = "",
    val lastName: String = "",
    val age: Int = 0,
    val gender: String = "",
    val location: Location = Location("unknown"),
    val interests: List<String> = emptyList(),
    val email: String = "",
    val password: String = "",
    val photos: List<String> = emptyList(),
)