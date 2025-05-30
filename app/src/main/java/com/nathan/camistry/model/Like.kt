package com.nathan.camistry.model

import com.google.firebase.Timestamp

data class Like(
    val fromUserId: String,
    val toUserId: String,
    val liked: Boolean,
    val timestamp: Timestamp
)