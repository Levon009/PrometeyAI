package com.xxlionxx.prometey.data.local.entity

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "forecast_sources")
data class ForecastSourceEntity(
    @PrimaryKey
    val id: String,
    val title: String,
    val url: String?,
    val publisher: String?,
    val publishedAt: Long?,
    val retrievedAt: Long
)
