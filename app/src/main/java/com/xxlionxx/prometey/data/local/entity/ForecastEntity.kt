package com.xxlionxx.prometey.data.local.entity

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "forecasts")
data class ForecastEntity(
    @PrimaryKey val id: String,
    val userId: String,
    val question: String,
    val topic: String,
    val summary: String,
    val confidence: Float,
    val timeHorizon: String,
    val riskLevel: String,
    val uncertainty: String,
    val createdAt: Long,
    val updatedAt: Long
)
