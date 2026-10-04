package com.xxlionxx.prometey.domain.useCases

import com.xxlionxx.prometey.domain.repository.ForecastRepository

class DeleteForecastUseCase(
    private val forecastRepository: ForecastRepository
) {

    suspend operator fun invoke(id: String) {
        forecastRepository.deleteForecast(id)
    }
}