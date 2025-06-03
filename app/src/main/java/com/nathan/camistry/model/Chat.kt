package com.nathan.camistry.model

import com.google.firebase.Timestamp

data class Chat(
    val chatId: String = "",
    val userIds: List<String> = emptyList(),
    val lastMessage: Message? = null,
    val updatedAt: Timestamp = Timestamp.now()
)