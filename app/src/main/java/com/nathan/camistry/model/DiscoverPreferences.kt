package com.nathan.camistry.model

data class DiscoverPreferences(
    val userId: String,
    val minAge: Int,
    val maxAge: Int,
    val preferredGender: List<String>,
    val maxDistanceKm: Int
)