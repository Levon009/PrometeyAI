package com.xxlionxx.prometey.data.local.dao

import androidx.room.Dao
import androidx.room.Delete
import androidx.room.Insert
import androidx.room.Query
import androidx.room.Update
import com.xxlionxx.prometey.data.local.entity.UserGoalEntity

@Dao
interface UserGoalDao {

    @Query("SELECT * FROM user_goals WHERE userId = :userId")
    suspend fun getGoals(userId: String): List<UserGoalEntity>

    @Query("SELECT * FROM user_goals WHERE id = :id")
    suspend fun getGoalById(id: String): UserGoalEntity?

    @Insert
    suspend fun insertGoal(goal: UserGoalEntity)

    @Update
    suspend fun updateGoal(goal: UserGoalEntity)

    @Delete
    suspend fun deleteGoal(goal: UserGoalEntity)
}