package com.xxlionxx.prometey.domain.useCases

import com.xxlionxx.prometey.domain.repository.ForecastFactorRepository

class DeleteForecastFactorUseCase(
    private val forecastFactorRepository: ForecastFactorRepository
) {

    suspend operator fun invoke(id: String) {
        forecastFactorRepository.deleteFactor(id)
    }
}