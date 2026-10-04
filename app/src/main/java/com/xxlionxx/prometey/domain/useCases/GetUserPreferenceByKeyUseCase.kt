package com.xxlionxx.prometey.domain.useCases

import com.xxlionxx.prometey.domain.model.UserPreference
import com.xxlionxx.prometey.domain.repository.UserPreferenceRepository

class GetUserPreferenceByKeyUseCase(
    private val userPreferenceRepository: UserPreferenceRepository
) {

    suspend operator fun invoke(userId: String, key: String): UserPreference? {
        return userPreferenceRepository.getPreferences(userId).firstOrNull { it.key == key }
    }
}