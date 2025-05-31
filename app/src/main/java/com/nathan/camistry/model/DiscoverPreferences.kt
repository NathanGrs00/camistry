package com.nathan.camistry.model

data class DiscoverPreferences(
    val userId: String = "",
    val minAge: Int = 18,
    val maxAge: Int = 99,
    val preferredGender: List<String> = emptyList(),
    val maxDistanceKm: Int = 50,
)