package com.xxlionxx.prometey.data.local.entity

import androidx.room.Entity
import androidx.room.Index
import androidx.room.PrimaryKey

@Entity(
    tableName = "forecast_scenarios",
    indices = [
        Index(value = ["forecastId"])
    ]
)
data class ForecastScenarioEntity(
    @PrimaryKey
    val id: String,
    val forecastId: String,
    val title: String,
    val description: String,
    val probability: Float,
    val impact: Float
)
