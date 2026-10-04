package com.xxlionxx.prometey.domain.useCases

import com.xxlionxx.prometey.domain.repository.UserGoalRepository

class DeleteUserGoalUseCase(
    private val userGoalRepository: UserGoalRepository
) {

    suspend operator fun invoke(id: String) {
        userGoalRepository.deleteGoal(id)
    }
}