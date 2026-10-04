package com.xxlionxx.prometey.domain.useCases

import com.xxlionxx.prometey.domain.model.ForecastRecommendation
import com.xxlionxx.prometey.domain.repository.ForecastRecommendationRepository

class GetForecastRecommendationsUseCase(
    private val forecastRecommendationRepository: ForecastRecommendationRepository
) {

    suspend operator fun invoke(
        forecastId: String
    ): List<ForecastRecommendation> {
        return forecastRecommendationRepository.getRecommendations(forecastId)
    }
}