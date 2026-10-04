package com.xxlionxx.prometey.data.repository

import com.xxlionxx.prometey.data.local.dao.ForecastDao
import com.xxlionxx.prometey.data.local.mapper.toDomain
import com.xxlionxx.prometey.data.local.mapper.toEntity
import com.xxlionxx.prometey.domain.model.Forecast
import com.xxlionxx.prometey.domain.repository.ForecastRepository

class ForecastRepositoryImpl(
    private val dao: ForecastDao
) : ForecastRepository {

    override suspend fun getForecasts(
        userId: String
    ): List<Forecast> {
        return dao.getForecasts(userId)
            .map { it.toDomain() }
    }

    override suspend fun getForecastById(
        id: String
    ): Forecast? {
        return dao.getForecastById(id)
            ?.toDomain()
    }

    override suspend fun saveForecast(
        forecast: Forecast
    ) {
        dao.insertForecast(
            forecast.toEntity()
        )
    }

    override suspend fun updateForecast(
        forecast: Forecast
    ) {
        dao.updateForecast(
            forecast.toEntity()
        )
    }

    override suspend fun deleteForecast(
        id: String
    ) {
        val forecast = dao.getForecastById(id)
            ?: return

        dao.deleteForecast(forecast)
    }
}