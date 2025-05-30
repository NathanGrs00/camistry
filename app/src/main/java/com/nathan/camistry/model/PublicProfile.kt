package com.nathan.camistry.model

import android.location.Location

data class PublicProfile (
    val id: String,
    val firstName: String,
    val age: Int,
    val gender: String,
    val location: Location,
    val interests: List<String>,
    val photos: List<String>
)