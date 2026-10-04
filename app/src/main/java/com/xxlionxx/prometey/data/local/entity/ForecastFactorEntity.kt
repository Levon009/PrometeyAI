package com.xxlionxx.prometey.data.local.entity

import androidx.room.Entity
import androidx.room.Index
import androidx.room.PrimaryKey

@Entity(
    tableName = "forecast_factors",
    indices = [
        Index(value = ["forecastId"])
    ]
)
data class ForecastFactorEntity(
    @PrimaryKey
    val id: String,
    val forecastId: String,
    val title: String,
    val description: String,
    val impact: Float,
    val source: String?
)
