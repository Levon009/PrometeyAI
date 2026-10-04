package com.xxlionxx.prometey.domain.useCases

import com.xxlionxx.prometey.domain.model.UserGoal
import com.xxlionxx.prometey.domain.repository.UserGoalRepository

class SaveUserGoalUseCase(
    private val userGoalRepository: UserGoalRepository
) {

    suspend operator fun invoke(goal: UserGoal) {
        userGoalRepository.saveGoal(goal)
    }
}