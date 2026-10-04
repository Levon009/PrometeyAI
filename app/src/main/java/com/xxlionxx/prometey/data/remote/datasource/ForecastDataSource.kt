package com.xxlionxx.prometey.data.remote.datasource

import com.xxlionxx.prometey.domain.model.ForecastSource

interface ForecastDataSource {

    suspend fun getSources(
        topic: String,
        query: String
    ): List<ForecastSource>
}