package com.nathan.camistry.model

import android.location.Location

data class PublicProfile(
    val id: String = "",
    val firstName: String = "",
    val age: Int = 18,
    val heightCm: Int = 0,
    val gender: String = "",
    val orientation: String? = null,
    val intentions: String? = null,
    val languages: List<String> = emptyList(),
    val location: Location = Location("unknown"), // assuming Location has a default constructor
    val jobTitle: String? = null,
    val education: String? = null,
    val bio: String? = null,
    val smokes: Boolean? = null,
    val drinks: Boolean? = null,
    val hasPets: String? = null,
    val wantsChildren: String? = null,
    val interests: List<String> = emptyList(),
    val photos: List<String> = emptyList(),
    val isVerified: Boolean = false,
    val isOnline: Boolean = false,

    // Instagram
    val instagramName: String? = null,
    val instagramConnected: Boolean = false,
    val showInstagram: Boolean = false,

    // Spotify
    val spotifyConnected: Boolean = false,
    val showSpotify: Boolean = false,
    val topArtists: List<String>? = emptyList(),
    val anthemTrackName: String? = null,
    val anthemTrackUrl: String? = null,

    // Moderation
    val reportCount: Int = 0,
    val isBanned: Boolean = false
)
