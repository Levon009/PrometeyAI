package com.xxlionxx.prometey.data.remote.datasource

import com.xxlionxx.prometey.domain.model.ForecastSource

class ForecastDataSourceImpl : ForecastDataSource {

    override suspend fun getSources(
        topic: String,
        query: String
    ): List<ForecastSource> {
        return emptyList()
    }
}