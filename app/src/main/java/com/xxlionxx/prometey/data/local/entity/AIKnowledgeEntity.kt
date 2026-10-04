package com.xxlionxx.prometey.data.local.entity

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "ai_knowledge")
data class AIKnowledgeEntity(
    @PrimaryKey
    val id: String,
    val topic: String,
    val content: String,
    val source: String,
    val status: String,
    val confidence: Float,
    val createdAt: Long,
    val updatedAt: Long
)
