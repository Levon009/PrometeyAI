package com.xxlionxx.prometey.data.local.entity

import androidx.room.Entity
import androidx.room.Index
import androidx.room.PrimaryKey

@Entity(
    tableName = "forecast_recommendations",
    indices = [
        Index(value = ["forecastId"])
    ]
)
data class ForecastRecommendationEntity(
    @PrimaryKey
    val id: String,
    val forecastId: String,
    val title: String,
    val description: String,
    val priority: Int
)
