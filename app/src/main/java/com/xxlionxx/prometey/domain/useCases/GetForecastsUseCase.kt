package com.xxlionxx.prometey.domain.useCases

import com.xxlionxx.prometey.domain.model.Forecast
import com.xxlionxx.prometey.domain.repository.ForecastRepository

class GetForecastsUseCase(
    private val forecastRepository: ForecastRepository
) {

    suspend operator fun invoke(userId: String): List<Forecast> {
        return forecastRepository.getForecasts(userId)
    }
}