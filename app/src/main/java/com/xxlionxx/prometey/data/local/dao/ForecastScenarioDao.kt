package com.xxlionxx.prometey.data.local.dao

import androidx.room.Dao
import androidx.room.Delete
import androidx.room.Insert
import androidx.room.Query
import androidx.room.Update
import com.xxlionxx.prometey.data.local.entity.ForecastScenarioEntity

@Dao
interface ForecastScenarioDao {

    @Query("SELECT * FROM forecast_scenarios WHERE forecastId = :forecastId")
    suspend fun getScenarios(forecastId: String): List<ForecastScenarioEntity>

    @Query("SELECT * FROM forecast_scenarios WHERE id = :id")
    suspend fun getScenarioById(id: String): ForecastScenarioEntity?

    @Insert
    suspend fun insertScenario(scenario: ForecastScenarioEntity)

    @Update
    suspend fun updateScenario(scenario: ForecastScenarioEntity)

    @Delete
    suspend fun deleteScenario(scenario: ForecastScenarioEntity)
}