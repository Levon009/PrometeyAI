package com.xxlionxx.prometey.domain.repository

import com.xxlionxx.prometey.domain.model.ForecastFactor

interface ForecastFactorRepository {

    suspend fun getFactors(forecastId: String): List<ForecastFactor>

    suspend fun saveFactor(factor: ForecastFactor)

    suspend fun updateFactor(factor: ForecastFactor)

    suspend fun deleteFactor(id: String)
}