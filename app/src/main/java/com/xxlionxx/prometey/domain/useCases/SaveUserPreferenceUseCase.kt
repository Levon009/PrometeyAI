package com.xxlionxx.prometey.domain.useCases

import com.xxlionxx.prometey.domain.model.UserPreference
import com.xxlionxx.prometey.domain.repository.UserPreferenceRepository

class SaveUserPreferenceUseCase(
    private val userPreferenceRepository: UserPreferenceRepository
) {

    suspend operator fun invoke(preference: UserPreference) {
        userPreferenceRepository.savePreference(preference)
    }
}