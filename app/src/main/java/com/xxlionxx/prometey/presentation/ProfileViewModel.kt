package com.xxlionxx.prometey.presentation

import androidx.lifecycle.viewModelScope
import com.xxlionxx.prometey.domain.model.User
import com.xxlionxx.prometey.domain.model.UserProfile
import com.xxlionxx.prometey.domain.useCases.GetUserByIdUseCase
import com.xxlionxx.prometey.domain.useCases.GetUserProfileUseCase
import com.xxlionxx.prometey.domain.useCases.SaveUserProfileUseCase
import com.xxlionxx.prometey.domain.useCases.SaveUserUseCase
import com.xxlionxx.prometey.domain.useCases.UpdateUserProfileUseCase
import com.xxlionxx.prometey.domain.useCases.UpdateUserUseCase
import com.xxlionxx.prometey.presentation.events.ProfileEvent
import com.xxlionxx.prometey.presentation.states.ProfileState
import kotlinx.coroutines.launch

class ProfileViewModel(
    private val getUserByIdUseCase: GetUserByIdUseCase,
    private val saveUserUseCase: SaveUserUseCase,
    private val updateUserUseCase: UpdateUserUseCase,
    private val getUserProfileUseCase: GetUserProfileUseCase,
    private val saveUserProfileUseCase: SaveUserProfileUseCase,
    private val updateUserProfileUseCase: UpdateUserProfileUseCase
) : MviViewModel<ProfileEvent, ProfileState>(ProfileState()) {

    override fun onEvent(event: ProfileEvent) {
        when (event) {
            is ProfileEvent.LoadUser -> loadUser(event.userId)
            is ProfileEvent.LoadProfile -> loadProfile(event.userId)
            is ProfileEvent.SaveUser -> saveUser(event.user)
            is ProfileEvent.UpdateUser -> updateUser(event.user)
            is ProfileEvent.SaveProfile -> saveProfile(event.profile)
            is ProfileEvent.UpdateProfile -> updateProfile(event.profile)
            ProfileEvent.ClearProfile -> updateState { ProfileState() }
        }
    }

    private fun loadUser(userId: String) {
        viewModelScope.launch {
            updateState {
                it.copy(
                    isLoading = true,
                    error = null
                )
            }

            try {
                val user = getUserByIdUseCase(userId)

                updateState {
                    it.copy(
                        user = user,
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

    private fun loadProfile(userId: String) {
        viewModelScope.launch {
            updateState {
                it.copy(
                    isLoading = true,
                    error = null
                )
            }

            try {
                val profile = getUserProfileUseCase(userId)

                updateState {
                    it.copy(
                        profile = profile,
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

    private fun saveUser(user: User) {
        viewModelScope.launch {
            updateState {
                it.copy(
                    isSaving = true,
                    error = null
                )
            }

            try {
                saveUserUseCase(user)

                updateState {
                    it.copy(
                        user = user,
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

    private fun updateUser(user: User) {
        viewModelScope.launch {
            updateState {
                it.copy(
                    isSaving = true,
                    error = null
                )
            }

            try {
                updateUserUseCase(user)

                updateState {
                    it.copy(
                        user = user,
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

    private fun saveProfile(profile: UserProfile) {
        viewModelScope.launch {
            updateState {
                it.copy(
                    isSaving = true,
                    error = null
                )
            }

            try {
                saveUserProfileUseCase(profile)

                updateState {
                    it.copy(
                        profile = profile,
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

    private fun updateProfile(profile: UserProfile) {
        viewModelScope.launch {
            updateState {
                it.copy(
                    isSaving = true,
                    error = null
                )
            }

            try {
                updateUserProfileUseCase(profile)

                updateState {
                    it.copy(
                        profile = profile,
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
}