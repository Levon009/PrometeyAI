package com.xxlionxx.prometey.domain.useCases

import com.xxlionxx.prometey.domain.model.UserProfile
import com.xxlionxx.prometey.domain.repository.UserProfileRepository

class SaveUserProfileUseCase(
    private val userProfileRepository: UserProfileRepository
) {

    suspend operator fun invoke(profile: UserProfile) {
        userProfileRepository.saveProfile(profile)
    }
}