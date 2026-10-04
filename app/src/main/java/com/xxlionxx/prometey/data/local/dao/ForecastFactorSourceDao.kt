package com.xxlionxx.prometey.data.local.dao

import androidx.room.Dao
import androidx.room.Delete
import androidx.room.Insert
import androidx.room.Query
import com.xxlionxx.prometey.data.local.entity.ForecastFactorSourceEntity

@Dao
interface ForecastFactorSourceDao {

    @Query("SELECT * FROM forecast_factor_sources WHERE factorId = :factorId")
    suspend fun getSourcesForFactor(
        factorId: String
    ): List<ForecastFactorSourceEntity>

    @Query("SELECT * FROM forecast_factor_sources WHERE factorId = :factorId AND sourceId = :sourceId")
    suspend fun getRelation(
        factorId: String,
        sourceId: String
    ): ForecastFactorSourceEntity?

    @Insert
    suspend fun insertRelation(
        relation: ForecastFactorSourceEntity
    )

    @Delete
    suspend fun deleteRelation(
        relation: ForecastFactorSourceEntity
    )
}