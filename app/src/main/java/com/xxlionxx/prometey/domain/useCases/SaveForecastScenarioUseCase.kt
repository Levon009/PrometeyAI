package com.xxlionxx.prometey.domain.useCases

import com.xxlionxx.prometey.domain.model.ForecastScenario
import com.xxlionxx.prometey.domain.repository.ForecastScenarioRepository

class SaveForecastScenarioUseCase(
    private val forecastScenarioRepository: ForecastScenarioRepository
) {

    suspend operator fun invoke(scenario: ForecastScenario) {
        forecastScenarioRepository.saveScenario(scenario)
    }
}