package com.xxlionxx.prometey.presentation.events

import com.xxlionxx.prometey.domain.model.UserGoal

sealed interface GoalEvent : MviEvent {

    data class LoadGoals(val userId: String) : GoalEvent

    data class LoadGoal(val goalId: String) : GoalEvent

    data class SaveGoal(val goal: UserGoal) : GoalEvent

    data class UpdateGoal(val goal: UserGoal) : GoalEvent

    data class DeleteGoal(val goalId: String) : GoalEvent

    data class Refresh(val userId: String) : GoalEvent
}