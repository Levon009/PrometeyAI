package com.xxlionxx.prometey.domain.useCases

import com.xxlionxx.prometey.domain.model.ForecastFactorSource
import com.xxlionxx.prometey.domain.repository.ForecastFactorSourceRepository

class GetForecastFactorSourcesUseCase(
    private val forecastFactorSourceRepository: ForecastFactorSourceRepository
) {

    suspend operator fun invoke(factorId: String): List<ForecastFactorSource> {
        return forecastFactorSourceRepository.getSourcesForFactor(factorId)
    }
}