package com.xxlionxx.prometey.domain.model

data class Forecast(
    val id: String,
    val userId: String,
    val question: String,
    val topic: ForecastTopic,
    val summary: String,
    val confidence: Float,
    val timeHorizon: ForecastTimeHorizon,
    val riskLevel: ForecastRiskLevel,
    val uncertainty: ForecastUncertainty,
    val createdAt: Long,
    val updatedAt: Long
)
