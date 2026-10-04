package com.xxlionxx.prometey.domain.useCases

import com.xxlionxx.prometey.domain.model.UserProfile
import com.xxlionxx.prometey.domain.repository.UserProfileRepository

class UpdateUserProfileUseCase(
    private val userProfileRepository: UserProfileRepository
) {

    suspend operator fun invoke(profile: UserProfile) {
        userProfileRepository.updateProfile(profile)
    }
}