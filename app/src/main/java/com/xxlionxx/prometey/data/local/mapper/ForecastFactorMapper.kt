package com.xxlionxx.prometey.data.local.mapper

import com.xxlionxx.prometey.data.local.entity.ForecastFactorEntity
import com.xxlionxx.prometey.domain.model.ForecastFactor

fun ForecastFactorEntity.toDomain(): ForecastFactor {
    return ForecastFactor(
        id = id,
        forecastId = forecastId,
        title = title,
        description = description,
        impact = impact,
        source = source
    )
}

fun ForecastFactor.toEntity(): ForecastFactorEntity {
    return ForecastFactorEntity(
        id = id,
        forecastId = forecastId,
        title = title,
        description = description,
        impact = impact,
        source = source
    )
}