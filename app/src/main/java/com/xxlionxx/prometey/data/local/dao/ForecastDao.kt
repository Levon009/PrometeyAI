package com.xxlionxx.prometey.data.local.dao

import androidx.room.Dao
import androidx.room.Delete
import androidx.room.Insert
import androidx.room.Query
import androidx.room.Update
import com.xxlionxx.prometey.data.local.entity.ForecastEntity

@Dao
interface ForecastDao {

    @Query("SELECT * FROM forecasts WHERE userId = :userId")
    suspend fun getForecasts(userId: String): List<ForecastEntity>

    @Query("SELECT * FROM forecasts WHERE id = :id")
    suspend fun getForecastById(id: String): ForecastEntity?

    @Insert
    suspend fun insertForecast(forecast: ForecastEntity)

    @Update
    suspend fun updateForecast(forecast: ForecastEntity)

    @Delete
    suspend fun deleteForecast(forecast: ForecastEntity)
}