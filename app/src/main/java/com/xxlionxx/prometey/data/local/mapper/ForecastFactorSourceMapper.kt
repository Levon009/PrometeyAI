package com.xxlionxx.prometey.data.local.mapper

import com.xxlionxx.prometey.data.local.entity.ForecastFactorSourceEntity
import com.xxlionxx.prometey.domain.model.ForecastFactorSource

fun ForecastFactorSourceEntity.toDomain(): ForecastFactorSource {
    return ForecastFactorSource(
        factorId = factorId,
        sourceId = sourceId
    )
}

fun ForecastFactorSource.toEntity(): ForecastFactorSourceEntity {
    return ForecastFactorSourceEntity(
        factorId = factorId,
        sourceId = sourceId
    )
}