package com.xxlionxx.prometey.data.local.mapper

import com.xxlionxx.prometey.data.local.entity.ForecastScenarioEntity
import com.xxlionxx.prometey.domain.model.ForecastScenario

fun ForecastScenarioEntity.toDomain(): ForecastScenario {
    return ForecastScenario(
        id = id,
        forecastId = forecastId,
        title = title,
        description = description,
        probability = probability,
        impact = impact
    )
}

fun ForecastScenario.toEntity(): ForecastScenarioEntity {
    return ForecastScenarioEntity(
        id = id,
        forecastId = forecastId,
        title = title,
        description = description,
        probability = probability,
        impact = impact
    )
}