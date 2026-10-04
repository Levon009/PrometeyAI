package com.xxlionxx.prometey.domain.useCases

import com.xxlionxx.prometey.domain.repository.ForecastFactorSourceRepository

class DeleteForecastFactorSourceUseCase(
    private val forecastFactorSourceRepository: ForecastFactorSourceRepository
) {

    suspend operator fun invoke(
        factorId: String,
        sourceId: String
    ) {
        forecastFactorSourceRepository.deleteRelation(
            factorId = factorId,
            sourceId = sourceId
        )
    }
}