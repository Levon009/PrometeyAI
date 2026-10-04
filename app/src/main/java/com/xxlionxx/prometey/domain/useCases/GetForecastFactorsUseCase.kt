package com.xxlionxx.prometey.domain.useCases

import com.xxlionxx.prometey.domain.model.ForecastFactor
import com.xxlionxx.prometey.domain.repository.ForecastFactorRepository

class GetForecastFactorsUseCase(
    private val forecastFactorRepository: ForecastFactorRepository
) {

    suspend operator fun invoke(forecastId: String): List<ForecastFactor> {
        return forecastFactorRepository.getFactors(forecastId)
    }
}