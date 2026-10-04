package com.xxlionxx.prometey.domain.useCases

import com.xxlionxx.prometey.domain.repository.ForecastSourceRepository

class DeleteForecastSourceUseCase(
    private val forecastSourceRepository: ForecastSourceRepository
) {

    suspend operator fun invoke(id: String) {
        forecastSourceRepository.deleteSource(id)
    }
}