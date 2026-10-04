package com.xxlionxx.prometey.domain.model

data class ForecastRecommendation(
    val id: String,
    val forecastId: String,
    val title: String,
    val description: String,
    val priority: Int
)
