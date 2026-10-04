package com.xxlionxx.prometey.data.repository

import com.xxlionxx.prometey.data.remote.datasource.ForecastDataSource
import com.xxlionxx.prometey.domain.model.ForecastSource
import com.xxlionxx.prometey.domain.repository.ForecastDataRepository

class ForecastDataRepositoryImpl(
    private val dataSource: ForecastDataSource
) : ForecastDataRepository {

    override suspend fun getSources(
        topic: String,
        query: String
    ): List<ForecastSource> {
        return dataSource.getSources(
            topic = topic,
            query = query
        )
    }
}