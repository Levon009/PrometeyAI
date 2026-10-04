package com.xxlionxx.prometey.data.local.dao

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.Query
import androidx.room.Update
import com.xxlionxx.prometey.data.local.entity.AISettingsEntity

@Dao
interface AISettingsDao {

    @Query("SELECT * FROM ai_settings WHERE id = :id")
    suspend fun getSettings(id: String): AISettingsEntity?

    @Insert
    suspend fun insertSettings(settings: AISettingsEntity)

    @Update
    suspend fun updateSettings(settings: AISettingsEntity)
}