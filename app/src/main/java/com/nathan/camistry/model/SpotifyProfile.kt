package com.nathan.camistry.model

data class SpotifyProfile(
    val spotifyUsername: String = "",
    val profileImageUrl: String? = null,
    val topArtists: List<String> = emptyList(),
    val anthemTrackName: String? = null,
    val anthemTrackUrl: String? = null,
)