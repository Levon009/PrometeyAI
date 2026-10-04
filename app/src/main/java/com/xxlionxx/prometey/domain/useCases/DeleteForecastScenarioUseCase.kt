package com.xxlionxx.prometey.domain.useCases

import com.xxlionxx.prometey.domain.repository.ForecastScenarioRepository

class DeleteForecastScenarioUseCase(
    private val forecastScenarioRepository: ForecastScenarioRepository
) {

    suspend operator fun invoke(id: String) {
        forecastScenarioRepository.deleteScenario(id)
    }
}