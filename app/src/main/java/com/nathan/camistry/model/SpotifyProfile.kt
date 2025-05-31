package com.nathan.camistry.model

data class SpotifyProfile(
    val spotifyUsername: String,
    val profileImageUrl: String?,
    val topArtists: List<String>,
    val anthemTrackName: String?,
    val anthemTrackUrl: String?
)