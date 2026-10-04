package com.xxlionxx.prometey.data.repository

import com.xxlionxx.prometey.data.local.dao.ForecastRecommendationDao
import com.xxlionxx.prometey.data.local.mapper.toDomain
import com.xxlionxx.prometey.data.local.mapper.toEntity
import com.xxlionxx.prometey.domain.model.ForecastRecommendation
import com.xxlionxx.prometey.domain.repository.ForecastRecommendationRepository

class ForecastRecommendationRepositoryImpl(
    private val dao: ForecastRecommendationDao
) : ForecastRecommendationRepository {

    override suspend fun getRecommendations(
        forecastId: String
    ): List<ForecastRecommendation> {
        return dao.getRecommendations(forecastId)
            .map { it.toDomain() }
    }

    override suspend fun saveRecommendation(
        recommendation: ForecastRecommendation
    ) {
        dao.insertRecommendation(
            recommendation.toEntity()
        )
    }

    override suspend fun updateRecommendation(
        recommendation: ForecastRecommendation
    ) {
        dao.updateRecommendation(
            recommendation.toEntity()
        )
    }
}