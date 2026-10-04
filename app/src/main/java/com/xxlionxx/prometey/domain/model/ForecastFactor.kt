package com.xxlionxx.prometey.domain.model

data class ForecastFactor(
    val id: String,
    val forecastId: String,
    val title: String,
    val description: String,
    val impact: Float,
    val source: String?
)
