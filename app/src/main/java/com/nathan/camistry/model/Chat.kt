package com.nathan.camistry.model

import com.google.firebase.Timestamp

data class Chat(
    val chatId: String,
    val userIds: List<String>,
    val lastMessage: Message?,
    val updatedAt: Timestamp
)
