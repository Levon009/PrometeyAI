package com.xxlionxx.prometey.data.local.entity

import androidx.room.Entity
import androidx.room.Index

@Entity(
    tableName = "forecast_factor_sources",
    primaryKeys = ["factorId", "sourceId"],
    indices = [
        Index(value = ["sourceId"])
    ]
)
data class ForecastFactorSourceEntity(
    val factorId: String,
    val sourceId: String
)