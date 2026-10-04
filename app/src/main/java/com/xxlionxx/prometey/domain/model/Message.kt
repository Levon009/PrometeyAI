package com.xxlionxx.prometey.domain.model

data class Message(
    val id: String,
    val conversationId: String,
    val role: MessageRole,
    val content: String,
    val attachments: List<Attachment>,
    val createdAt: Long
)
