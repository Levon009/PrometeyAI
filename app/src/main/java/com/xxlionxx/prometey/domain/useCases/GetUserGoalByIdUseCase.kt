package com.xxlionxx.prometey.domain.useCases

import com.xxlionxx.prometey.domain.model.UserGoal
import com.xxlionxx.prometey.domain.repository.UserGoalRepository

class GetUserGoalByIdUseCase(
    private val userGoalRepository: UserGoalRepository
) {

    suspend operator fun invoke(id: String): UserGoal? {
        return userGoalRepository.getGoalById(id)
    }
}