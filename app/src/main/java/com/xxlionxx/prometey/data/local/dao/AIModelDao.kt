package com.xxlionxx.prometey.data.local.dao

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.Query
import androidx.room.Update
import com.xxlionxx.prometey.data.local.entity.AIModelEntity

@Dao
interface AIModelDao {

    @Query("SELECT * FROM ai_models")
    suspend fun getAvailableModels(): List<AIModelEntity>

    @Query("SELECT * FROM ai_models WHERE id = :id")
    suspend fun getModelById(id: String): AIModelEntity?

    @Insert
    suspend fun insertModel(model: AIModelEntity)

    @Update
    suspend fun updateModel(model: AIModelEntity)
}