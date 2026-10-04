package com.xxlionxx.prometey.domain.useCases

import com.xxlionxx.prometey.domain.model.ForecastScenario
import com.xxlionxx.prometey.domain.repository.ForecastScenarioRepository

class GetForecastScenariosUseCase(
    private val forecastScenarioRepository: ForecastScenarioRepository
) {

    suspend operator fun invoke(forecastId: String): List<ForecastScenario> {
        return forecastScenarioRepository.getScenarios(forecastId)
    }
}