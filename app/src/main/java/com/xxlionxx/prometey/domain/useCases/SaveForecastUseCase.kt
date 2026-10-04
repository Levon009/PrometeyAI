package com.xxlionxx.prometey.domain.useCases

import com.xxlionxx.prometey.domain.model.Forecast
import com.xxlionxx.prometey.domain.repository.ForecastRepository

class SaveForecastUseCase(
    private val forecastRepository: ForecastRepository
) {

    suspend operator fun invoke(forecast: Forecast) {
        forecastRepository.saveForecast(forecast)
    }
}