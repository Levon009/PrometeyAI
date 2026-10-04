package com.xxlionxx.prometey.domain.repository

import com.xxlionxx.prometey.domain.model.UserGoal

interface UserGoalRepository {

    suspend fun getGoals(userId: String): List<UserGoal>

    suspend fun getGoalById(id: String): UserGoal?

    suspend fun saveGoal(goal: UserGoal)

    suspend fun updateGoal(goal: UserGoal)

    suspend fun deleteGoal(id: String)
}