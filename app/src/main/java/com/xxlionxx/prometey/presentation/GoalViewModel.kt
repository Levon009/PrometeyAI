package com.xxlionxx.prometey.presentation

import androidx.lifecycle.viewModelScope
import com.xxlionxx.prometey.domain.model.UserGoal
import com.xxlionxx.prometey.domain.useCases.DeleteUserGoalUseCase
import com.xxlionxx.prometey.domain.useCases.GetUserGoalByIdUseCase
import com.xxlionxx.prometey.domain.useCases.GetUserGoalsUseCase
import com.xxlionxx.prometey.domain.useCases.SaveUserGoalUseCase
import com.xxlionxx.prometey.domain.useCases.UpdateUserGoalUseCase
import com.xxlionxx.prometey.presentation.events.GoalEvent
import com.xxlionxx.prometey.presentation.states.GoalState
import kotlinx.coroutines.launch

class GoalViewModel(
    private val getUserGoalsUseCase: GetUserGoalsUseCase,
    private val getUserGoalByIdUseCase: GetUserGoalByIdUseCase,
    private val saveUserGoalUseCase: SaveUserGoalUseCase,
    private val updateUserGoalUseCase: UpdateUserGoalUseCase,
    private val deleteUserGoalUseCase: DeleteUserGoalUseCase
) : MviViewModel<GoalEvent, GoalState>(GoalState()) {

    override fun onEvent(event: GoalEvent) {
        when (event) {
            is GoalEvent.LoadGoals -> loadGoals(event.userId)
            is GoalEvent.LoadGoal -> loadGoal(event.goalId)
            is GoalEvent.SaveGoal -> saveGoal(event.goal)
            is GoalEvent.UpdateGoal -> updateGoal(event.goal)
            is GoalEvent.DeleteGoal -> deleteGoal(event.goalId)
            is GoalEvent.Refresh -> loadGoals(event.userId)
        }
    }

    private fun loadGoals(userId: String) {
        viewModelScope.launch {
            updateState {
                it.copy(
                    isLoading = true,
                    error = null
                )
            }

            try {
                val goals = getUserGoalsUseCase(userId)

                updateState {
                    it.copy(
                        goals = goals,
                        isLoading = false,
                        error = null
                    )
                }
            } catch (exception: Exception) {
                updateState {
                    it.copy(
                        isLoading = false,
                        error = exception.message
                    )
                }
            }
        }
    }

    private fun loadGoal(goalId: String) {
        viewModelScope.launch {
            updateState {
                it.copy(
                    isLoading = true,
                    error = null
                )
            }

            try {
                val goal = getUserGoalByIdUseCase(goalId)

                updateState {
                    it.copy(
                        selectedGoal = goal,
                        isLoading = false,
                        error = null
                    )
                }
            } catch (exception: Exception) {
                updateState {
                    it.copy(
                        isLoading = false,
                        error = exception.message
                    )
                }
            }
        }
    }

    private fun saveGoal(goal: UserGoal) {
        viewModelScope.launch {
            updateState {
                it.copy(
                    isSaving = true,
                    error = null
                )
            }

            try {
                saveUserGoalUseCase(goal)

                updateState {
                    it.copy(
                        goals = it.goals
                            .filterNot { existing -> existing.id == goal.id } + goal,
                        selectedGoal = goal,
                        isSaving = false,
                        error = null
                    )
                }
            } catch (exception: Exception) {
                updateState {
                    it.copy(
                        isSaving = false,
                        error = exception.message
                    )
                }
            }
        }
    }

    private fun updateGoal(goal: UserGoal) {
        viewModelScope.launch {
            updateState {
                it.copy(
                    isSaving = true,
                    error = null
                )
            }

            try {
                updateUserGoalUseCase(goal)

                updateState {
                    it.copy(
                        goals = it.goals.map { existing ->
                            if (existing.id == goal.id) goal else existing
                        },
                        selectedGoal = goal,
                        isSaving = false,
                        error = null
                    )
                }
            } catch (exception: Exception) {
                updateState {
                    it.copy(
                        isSaving = false,
                        error = exception.message
                    )
                }
            }
        }
    }

    private fun deleteGoal(goalId: String) {
        viewModelScope.launch {
            updateState {
                it.copy(
                    isDeleting = true,
                    error = null
                )
            }

            try {
                deleteUserGoalUseCase(goalId)

                updateState {
                    it.copy(
                        goals = it.goals.filterNot { goal ->
                            goal.id == goalId
                        },
                        selectedGoal = if (it.selectedGoal?.id == goalId) {
                            null
                        } else {
                            it.selectedGoal
                        },
                        isDeleting = false,
                        error = null
                    )
                }
            } catch (exception: Exception) {
                updateState {
                    it.copy(
                        isDeleting = false,
                        error = exception.message
                    )
                }
            }
        }
    }
}