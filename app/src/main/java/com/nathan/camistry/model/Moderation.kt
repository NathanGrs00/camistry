package com.nathan.camistry.model

import com.google.firebase.Timestamp

data class Report(
    val reportedUserId: String = "",
    val reporterUserId: String = "",
    val reason: String = "",
    val timestamp: Timestamp = Timestamp.now()
)

data class Block(
    val blockedByUserId: String = "",
    val blockedUserId: String = "",
    val timestamp: Timestamp = Timestamp.now()
)