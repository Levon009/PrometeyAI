package com.xxlionxx.prometey.domain.repository

import com.xxlionxx.prometey.domain.model.Forecast

interface ForecastRepository {

    suspend fun getForecasts(userId: String): List<Forecast>

    suspend fun getForecastById(id: String): Forecast?

    suspend fun saveForecast(forecast: Forecast)

    suspend fun updateForecast(forecast: Forecast)

    suspend fun deleteForecast(id: String)
}