package com.xxlionxx.prometey.data.local.dao

import androidx.room.Dao
import androidx.room.Delete
import androidx.room.Insert
import androidx.room.Query
import androidx.room.Update
import com.xxlionxx.prometey.data.local.entity.ForecastFactorEntity

@Dao
interface ForecastFactorDao {

    @Query("SELECT * FROM forecast_factors WHERE forecastId = :forecastId")
    suspend fun getFactors(forecastId: String): List<ForecastFactorEntity>

    @Query("SELECT * FROM forecast_factors WHERE id = :id")
    suspend fun getFactorById(id: String): ForecastFactorEntity?

    @Insert
    suspend fun insertFactor(factor: ForecastFactorEntity)

    @Update
    suspend fun updateFactor(factor: ForecastFactorEntity)

    @Delete
    suspend fun deleteFactor(factor: ForecastFactorEntity)
}