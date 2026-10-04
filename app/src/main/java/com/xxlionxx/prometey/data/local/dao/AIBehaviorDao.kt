package com.xxlionxx.prometey.data.local.dao

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.Query
import androidx.room.Update
import com.xxlionxx.prometey.data.local.entity.AIBehaviorEntity

@Dao
interface AIBehaviorDao {

    @Query("SELECT * FROM ai_behavior WHERE id = :id")
    suspend fun getBehavior(id: Int): AIBehaviorEntity?

    @Insert
    suspend fun insertBehavior(behavior: AIBehaviorEntity)

    @Update
    suspend fun updateBehavior(behavior: AIBehaviorEntity)
}