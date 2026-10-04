package com.xxlionxx.prometey.data.local.entity

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "ai_instructions")
data class AIInstructionEntity(
    @PrimaryKey
    val id: String,
    val name: String,
    val content: String,
    val priority: Int,
    val isActive: Boolean
)
