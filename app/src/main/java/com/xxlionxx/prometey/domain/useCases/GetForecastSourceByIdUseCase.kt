package com.xxlionxx.prometey.domain.useCases

import com.xxlionxx.prometey.domain.model.ForecastSource
import com.xxlionxx.prometey.domain.repository.ForecastSourceRepository

class GetForecastSourceByIdUseCase(
    private val forecastSourceRepository: ForecastSourceRepository
) {

    suspend operator fun invoke(id: String): ForecastSource? {
        return forecastSourceRepository.getSourceById(id)
    }
}