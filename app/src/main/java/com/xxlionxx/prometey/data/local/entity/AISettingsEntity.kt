package com.xxlionxx.prometey.data.local.entity

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "ai_settings")
data class AISettingsEntity(
    @PrimaryKey
    val id: String,
    val modelId: String,
    val temperature: Float,
    val maxTokens: Int,
    val systemPrompt: String?
)
