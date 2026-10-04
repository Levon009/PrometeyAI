package com.xxlionxx.prometey.presentation

import androidx.lifecycle.viewModelScope
import com.xxlionxx.prometey.domain.model.UserPreference
import com.xxlionxx.prometey.domain.useCases.DeleteUserPreferenceUseCase
import com.xxlionxx.prometey.domain.useCases.GetUserPreferenceByKeyUseCase
import com.xxlionxx.prometey.domain.useCases.GetUserPreferencesUseCase
import com.xxlionxx.prometey.domain.useCases.SaveUserPreferenceUseCase
import com.xxlionxx.prometey.domain.useCases.UpdateUserPreferenceUseCase
import com.xxlionxx.prometey.presentation.events.PreferenceEvent
import com.xxlionxx.prometey.presentation.states.PreferenceState
import kotlinx.coroutines.launch

class PreferenceViewModel(
    private val getUserPreferencesUseCase: GetUserPreferencesUseCase,
    private val getUserPreferenceByKeyUseCase: GetUserPreferenceByKeyUseCase,
    private val saveUserPreferenceUseCase: SaveUserPreferenceUseCase,
    private val updateUserPreferenceUseCase: UpdateUserPreferenceUseCase,
    private val deleteUserPreferenceUseCase: DeleteUserPreferenceUseCase
) : MviViewModel<PreferenceEvent, PreferenceState>(PreferenceState()) {

    override fun onEvent(event: PreferenceEvent) {
        when (event) {
            is PreferenceEvent.LoadPreferences -> loadPreferences(event.userId)

            is PreferenceEvent.LoadPreferenceByKey -> {
                loadPreferenceByKey(event.userId, event.key)
            }

            is PreferenceEvent.SavePreference -> {
                savePreference(event.preference)
            }

            is PreferenceEvent.UpdatePreference -> {
                updatePreference(event.preference)
            }

            is PreferenceEvent.DeletePreference -> {
                deletePreference(event.preferenceId)
            }

            is PreferenceEvent.Refresh -> {
                loadPreferences(event.userId)
            }
        }
    }

    private fun loadPreferences(userId: String) {
        viewModelScope.launch {
            updateState {
                it.copy(
                    isLoading = true,
                    error = null
                )
            }

            try {
                val preferences = getUserPreferencesUseCase(userId)

                updateState {
                    it.copy(
                        preferences = preferences,
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

    private fun loadPreferenceByKey(
        userId: String,
        key: String
    ) {
        viewModelScope.launch {
            updateState {
                it.copy(
                    isLoading = true,
                    error = null
                )
            }

            try {
                val preference = getUserPreferenceByKeyUseCase(
                    userId,
                    key
                )

                updateState {
                    it.copy(
                        selectedPreference = preference,
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

    private fun savePreference(preference: UserPreference) {
        viewModelScope.launch {
            updateState {
                it.copy(
                    isSaving = true,
                    error = null
                )
            }

            try {
                saveUserPreferenceUseCase(preference)

                updateState {
                    it.copy(
                        preferences = it.preferences
                            .filterNot { existing ->
                                existing.id == preference.id
                            } + preference,
                        selectedPreference = preference,
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

    private fun updatePreference(preference: UserPreference) {
        viewModelScope.launch {
            updateState {
                it.copy(
                    isSaving = true,
                    error = null
                )
            }

            try {
                updateUserPreferenceUseCase(preference)

                updateState {
                    it.copy(
                        preferences = it.preferences.map { existing ->
                            if (existing.id == preference.id) {
                                preference
                            } else {
                                existing
                            }
                        },
                        selectedPreference = preference,
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

    private fun deletePreference(preferenceId: String) {
        viewModelScope.launch {
            updateState {
                it.copy(
                    isDeleting = true,
                    error = null
                )
            }

            try {
                deleteUserPreferenceUseCase(preferenceId)

                updateState {
                    it.copy(
                        preferences = it.preferences.filterNot { preference ->
                            preference.id == preferenceId
                        },
                        selectedPreference = if (
                            it.selectedPreference?.id == preferenceId
                        ) {
                            null
                        } else {
                            it.selectedPreference
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