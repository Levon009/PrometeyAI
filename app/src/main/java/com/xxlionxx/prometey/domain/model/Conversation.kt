package com.xxlionxx.prometey.domain.model

data class Conversation(
    val id: String,
    val userId: String,
    val title: String?,
    val status: ConversationStatus,
    val createdAt: Long,
    val updatedAt: Long
)
