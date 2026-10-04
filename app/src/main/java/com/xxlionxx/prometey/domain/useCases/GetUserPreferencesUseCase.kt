package com.xxlionxx.prometey.domain.useCases

import com.xxlionxx.prometey.domain.model.UserPreference
import com.xxlionxx.prometey.domain.repository.UserPreferenceRepository

class GetUserPreferencesUseCase(
    private val userPreferenceRepository: UserPreferenceRepository
) {

    suspend operator fun invoke(userId: String): List<UserPreference> {
        return userPreferenceRepository.getPreferences(userId)
    }
}