package com.xxlionxx.prometey.domain.useCases

import com.xxlionxx.prometey.domain.model.UserGoal
import com.xxlionxx.prometey.domain.repository.UserGoalRepository

class GetUserGoalsUseCase(
    private val userGoalRepository: UserGoalRepository
) {

    suspend operator fun invoke(userId: String): List<UserGoal> {
        return userGoalRepository.getGoals(userId)
    }
}