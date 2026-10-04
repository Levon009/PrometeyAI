package com.xxlionxx.prometey.data.local.dao

import androidx.room.Dao
import androidx.room.Delete
import androidx.room.Insert
import androidx.room.Query
import androidx.room.Update
import com.xxlionxx.prometey.data.local.entity.ForecastRecommendationEntity

@Dao
interface ForecastRecommendationDao {

    @Query(
        "SELECT * FROM forecast_recommendations " +
                "WHERE forecastId = :forecastId " +
                "ORDER BY priority DESC"
    )
    suspend fun getRecommendations(
        forecastId: String
    ): List<ForecastRecommendationEntity>

    @Insert
    suspend fun insertRecommendation(
        recommendation: ForecastRecommendationEntity
    )

    @Update
    suspend fun updateRecommendation(
        recommendation: ForecastRecommendationEntity
    )
}