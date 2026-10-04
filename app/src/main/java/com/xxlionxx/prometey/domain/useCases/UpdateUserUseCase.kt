package com.xxlionxx.prometey.domain.useCases

import com.xxlionxx.prometey.domain.model.User
import com.xxlionxx.prometey.domain.repository.UserRepository

class UpdateUserUseCase(
    private val userRepository: UserRepository
) {

    suspend operator fun invoke(user: User) {
        userRepository.updateUser(user)
    }
}