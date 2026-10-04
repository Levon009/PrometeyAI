package com.xxlionxx.prometey.domain.useCases

import com.xxlionxx.prometey.domain.repository.UserPreferenceRepository

class DeleteUserPreferenceUseCase(
    private val userPreferenceRepository: UserPreferenceRepository
) {

    suspend operator fun invoke(id: String) {
        userPreferenceRepository.deletePreference(id)
    }
}