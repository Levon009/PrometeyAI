package com.xxlionxx.prometey.domain.useCases

import com.xxlionxx.prometey.domain.model.ForecastSource
import com.xxlionxx.prometey.domain.repository.ForecastSourceRepository

class SaveForecastSourceUseCase(
    private val forecastSourceRepository: ForecastSourceRepository
) {

    suspend operator fun invoke(source: ForecastSource) {
        forecastSourceRepository.saveSource(source)
    }
}