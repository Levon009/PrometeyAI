package com.xxlionxx.prometey.data.local.entity

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "ai_behavior")
data class AIBehaviorEntity(
    @PrimaryKey
    val id: Int = 1,
    val kindness: Float,
    val empathy: Float,
    val verbosity: Float,
    val proactivity: Float
)
