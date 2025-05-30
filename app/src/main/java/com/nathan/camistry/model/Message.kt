package com.nathan.camistry.model

import com.google.firebase.Timestamp
import java.util.UUID

data class Message(
    val messageId: String = UUID.randomUUID().toString(),
    val senderId: String,
    val receiverId: String,
    val content: String,
    val timestamp: Timestamp,
    val isRead: Boolean = false
)