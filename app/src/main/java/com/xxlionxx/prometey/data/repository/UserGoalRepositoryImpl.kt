package com.xxlionxx.prometey.data.repository

import com.xxlionxx.prometey.data.local.dao.UserGoalDao
import com.xxlionxx.prometey.data.local.mapper.toDomain
import com.xxlionxx.prometey.data.local.mapper.toEntity
import com.xxlionxx.prometey.domain.model.UserGoal
import com.xxlionxx.prometey.domain.repository.UserGoalRepository

class UserGoalRepositoryImpl(
    private val dao: UserGoalDao
) : UserGoalRepository {

    override suspend fun getGoals(
        userId: String
    ): List<UserGoal> {
        return dao.getGoals(userId)
            .map { it.toDomain() }
    }

    override suspend fun getGoalById(
        id: String
    ): UserGoal? {
        return dao.getGoalById(id)
            ?.toDomain()
    }

    override suspend fun saveGoal(
        goal: UserGoal
    ) {
        dao.insertGoal(
            goal.toEntity()
        )
    }

    override suspend fun updateGoal(
        goal: UserGoal
    ) {
        dao.updateGoal(
            goal.toEntity()
        )
    }

    override suspend fun deleteGoal(
        id: String
    ) {
        val goal = dao.getGoalById(id)
            ?: return

        dao.deleteGoal(goal)
    }
}