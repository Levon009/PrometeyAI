package com.xxlionxx.prometey.domain.model

data class ForecastScenario(
    val id: String,
    val forecastId: String,
    val title: String,
    val description: String,
    val probability: Float,
    val impact: Float
)
