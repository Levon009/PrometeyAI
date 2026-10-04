package com.xxlionxx.prometey.data.local.mapper

import com.xxlionxx.prometey.data.local.entity.ForecastRecommendationEntity
import com.xxlionxx.prometey.domain.model.ForecastRecommendation

fun ForecastRecommendationEntity.toDomain(): ForecastRecommendation {
    return ForecastRecommendation(
        id = id,
        forecastId = forecastId,
        title = title,
        description = description,
        priority = priority
    )
}

fun ForecastRecommendation.toEntity(): ForecastRecommendationEntity {
    return ForecastRecommendationEntity(
        id = id,
        forecastId = forecastId,
        title = title,
        description = description,
        priority = priority
    )
}