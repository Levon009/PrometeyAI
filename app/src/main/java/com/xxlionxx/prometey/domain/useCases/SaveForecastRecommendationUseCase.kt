package com.xxlionxx.prometey.domain.useCases

import com.xxlionxx.prometey.domain.model.ForecastRecommendation
import com.xxlionxx.prometey.domain.repository.ForecastRecommendationRepository

class SaveForecastRecommendationUseCase(
    private val forecastRecommendationRepository: ForecastRecommendationRepository
) {

    suspend operator fun invoke(
        recommendation: ForecastRecommendation
    ) {
        forecastRecommendationRepository.saveRecommendation(recommendation)
    }
}