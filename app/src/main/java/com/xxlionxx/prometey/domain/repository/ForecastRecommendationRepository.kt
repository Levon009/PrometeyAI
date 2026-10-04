package com.xxlionxx.prometey.domain.repository

import com.xxlionxx.prometey.domain.model.ForecastRecommendation

interface ForecastRecommendationRepository {

    suspend fun getRecommendations(forecastId: String): List<ForecastRecommendation>

    suspend fun saveRecommendation(recommendation: ForecastRecommendation)

    suspend fun updateRecommendation(recommendation: ForecastRecommendation)
}