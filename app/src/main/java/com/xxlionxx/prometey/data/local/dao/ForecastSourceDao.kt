package com.xxlionxx.prometey.data.local.dao

import androidx.room.Dao
import androidx.room.Delete
import androidx.room.Insert
import androidx.room.Query
import com.xxlionxx.prometey.data.local.entity.ForecastSourceEntity

@Dao
interface ForecastSourceDao {

    @Query("SELECT * FROM forecast_sources WHERE id = :id")
    suspend fun getSourceById(id: String): ForecastSourceEntity?

    @Insert
    suspend fun insertSource(source: ForecastSourceEntity)

    @Delete
    suspend fun deleteSource(source: ForecastSourceEntity)
}