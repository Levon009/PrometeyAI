package com.xxlionxx.prometey.data.local.mapper

import com.xxlionxx.prometey.data.local.entity.ForecastEntity
import com.xxlionxx.prometey.domain.model.Forecast
import com.xxlionxx.prometey.domain.model.ForecastRiskLevel
import com.xxlionxx.prometey.domain.model.ForecastTimeHorizon
import com.xxlionxx.prometey.domain.model.ForecastTopic
import com.xxlionxx.prometey.domain.model.ForecastUncertainty

fun ForecastEntity.toDomain(): Forecast {
    return Forecast(
        id = id,
        userId = userId,
        question = question,
        topic = ForecastTopic.valueOf(topic),
        summary = summary,
        confidence = confidence,
        timeHorizon = ForecastTimeHorizon.valueOf(timeHorizon),
        riskLevel = ForecastRiskLevel.valueOf(riskLevel),
        uncertainty = ForecastUncertainty.valueOf(uncertainty),
        createdAt = createdAt,
        updatedAt = updatedAt
    )
}

fun Forecast.toEntity(): ForecastEntity {
    return ForecastEntity(
        id = id,
        userId = userId,
        question = question,
        topic = topic.name,
        summary = summary,
        confidence = confidence,
        timeHorizon = timeHorizon.name,
        riskLevel = riskLevel.name,
        uncertainty = uncertainty.name,
        createdAt = createdAt,
        updatedAt = updatedAt
    )
}