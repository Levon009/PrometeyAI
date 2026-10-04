package com.xxlionxx.prometey.domain.useCases

import com.xxlionxx.prometey.domain.model.User
import com.xxlionxx.prometey.domain.repository.UserRepository

class GetUserByIdUseCase(
    private val userRepository: UserRepository
) {
    suspend operator fun invoke(id: String): User? {
        return userRepository.getUserById(id)
    }
}