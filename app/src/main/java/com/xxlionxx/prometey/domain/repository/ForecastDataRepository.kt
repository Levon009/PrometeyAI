package com.xxlionxx.prometey.domain.repository

import com.xxlionxx.prometey.domain.model.ForecastSource

interface ForecastDataRepository {

    suspend fun getSources(topic: String, query: String): List<ForecastSource>
}