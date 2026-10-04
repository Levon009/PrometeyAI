package com.xxlionxx.prometey.domain.useCases

import com.xxlionxx.prometey.domain.model.UserProfile
import com.xxlionxx.prometey.domain.repository.UserProfileRepository

class GetUserProfileUseCase(
    private val userProfileRepository: UserProfileRepository
) {

    suspend operator fun invoke(userId: String): UserProfile? {
        return userProfileRepository.getProfile(userId)
    }
}