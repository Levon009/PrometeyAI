package com.xxlionxx.prometey.data.local.mapper

import com.xxlionxx.prometey.data.local.entity.ForecastSourceEntity
import com.xxlionxx.prometey.domain.model.ForecastSource

fun ForecastSourceEntity.toDomain(): ForecastSource {
    return ForecastSource(
        id = id,
        title = title,
        url = url,
        publisher = publisher,
        publishedAt = publishedAt,
        retrievedAt = retrievedAt
    )
}

fun ForecastSource.toEntity(): ForecastSourceEntity {
    return ForecastSourceEntity(
        id = id,
        title = title,
        url = url,
        publisher = publisher,
        publishedAt = publishedAt,
        retrievedAt = retrievedAt
    )
}