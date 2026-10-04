package com.xxlionxx.prometey.domain.useCases

import com.xxlionxx.prometey.domain.model.Forecast
import com.xxlionxx.prometey.domain.repository.ForecastRepository

class GetForecastByIdUseCase(
    private val forecastRepository: ForecastRepository
) {

    suspend operator fun invoke(id: String): Forecast? {
        return forecastRepository.getForecastById(id)
    }
}