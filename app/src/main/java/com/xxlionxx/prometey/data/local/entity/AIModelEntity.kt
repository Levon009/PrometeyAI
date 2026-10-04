package com.xxlionxx.prometey.data.local.entity

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "ai_models")
data class AIModelEntity(
    @PrimaryKey
    val id: String,
    val provider: String,
    val name: String,
    val isMultimodal: Boolean
)
