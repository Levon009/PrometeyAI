package com.xxlionxx.prometey.domain.model

data class AIKnowledge(
    val id: String,
    val topic: String,
    val content: String,
    val source: AIKnowledgeSource,
    val status: AIKnowledgeStatus,
    val confidence: Float,
    val createdAt: Long,
    val updatedAt: Long
)
