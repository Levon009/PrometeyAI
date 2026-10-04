package com.xxlionxx.prometey.domain.repository

import com.xxlionxx.prometey.domain.model.ForecastScenario

interface ForecastScenarioRepository {

    suspend fun getScenarios(forecastId: String): List<ForecastScenario>

    suspend fun saveScenario(scenario: ForecastScenario)

    suspend fun updateScenario(scenario: ForecastScenario)

    suspend fun deleteScenario(id: String)
}