package com.xxlionxx.prometey.domain.useCases

import com.xxlionxx.prometey.domain.model.ForecastFactor
import com.xxlionxx.prometey.domain.repository.ForecastFactorRepository

class SaveForecastFactorUseCase(
    private val forecastFactorRepository: ForecastFactorRepository
) {

    suspend operator fun invoke(factor: ForecastFactor) {
        forecastFactorRepository.saveFactor(factor)
    }
}