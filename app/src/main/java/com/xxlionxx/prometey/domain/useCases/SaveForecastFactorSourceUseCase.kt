package com.xxlionxx.prometey.domain.useCases

import com.xxlionxx.prometey.domain.model.ForecastFactorSource
import com.xxlionxx.prometey.domain.repository.ForecastFactorSourceRepository

class SaveForecastFactorSourceUseCase(
    private val forecastFactorSourceRepository: ForecastFactorSourceRepository
) {

    suspend operator fun invoke(relation: ForecastFactorSource) {
        forecastFactorSourceRepository.saveRelation(relation)
    }
}