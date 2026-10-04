package com.xxlionxx.prometey.data.local.dao

import androidx.room.Dao
import androidx.room.Delete
import androidx.room.Insert
import androidx.room.Query
import androidx.room.Update
import com.xxlionxx.prometey.data.local.entity.UserPreferenceEntity

@Dao
interface UserPreferenceDao {

    @Query("SELECT * FROM user_preferences WHERE userId = :userId")
    suspend fun getPreferences(userId: String): List<UserPreferenceEntity>

    @Query("SELECT * FROM user_preferences WHERE id = :id")
    suspend fun getPreferenceById(id: String): UserPreferenceEntity?

    @Insert
    suspend fun insertPreference(preference: UserPreferenceEntity)

    @Update
    suspend fun updatePreference(preference: UserPreferenceEntity)

    @Delete
    suspend fun deletePreference(preference: UserPreferenceEntity)
}