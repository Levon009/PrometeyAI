package com.xxlionxx.prometey.data.local.dao

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.Query
import androidx.room.Update
import com.xxlionxx.prometey.data.local.entity.AIActionPolicyEntity

@Dao
interface AIActionPolicyDao {

    @Query("SELECT * FROM ai_action_policies WHERE id = :id")
    suspend fun getPolicy(id: Int): AIActionPolicyEntity?

    @Insert
    suspend fun insertPolicy(policy: AIActionPolicyEntity)

    @Update
    suspend fun updatePolicy(policy: AIActionPolicyEntity)
}