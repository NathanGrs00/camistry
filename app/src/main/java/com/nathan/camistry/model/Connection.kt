package com.nathan.camistry.model

import com.google.firebase.Timestamp

data class Connection(
    val userId1: String,
    val userId2: String,
    val timestamp: Timestamp
)