package com.xxlionxx.prometey.data.repository

import com.xxlionxx.prometey.data.local.dao.ForecastScenarioDao
import com.xxlionxx.prometey.data.local.mapper.toDomain
import com.xxlionxx.prometey.data.local.mapper.toEntity
import com.xxlionxx.prometey.domain.model.ForecastScenario
import com.xxlionxx.prometey.domain.repository.ForecastScenarioRepository

class ForecastScenarioRepositoryImpl(
    private val dao: ForecastScenarioDao
) : ForecastScenarioRepository {

    override suspend fun getScenarios(
        forecastId: String
    ): List<ForecastScenario> {
        return dao.getScenarios(forecastId)
            .map { it.toDomain() }
    }

    override suspend fun saveScenario(
        scenario: ForecastScenario
    ) {
        dao.insertScenario(
            scenario.toEntity()
        )
    }

    override suspend fun updateScenario(
        scenario: ForecastScenario
    ) {
        dao.updateScenario(
            scenario.toEntity()
        )
    }

    override suspend fun deleteScenario(
        id: String
    ) {
        val scenario = dao.getScenarioById(id)
            ?: return

        dao.deleteScenario(scenario)
    }
}