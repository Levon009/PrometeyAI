package com.xxlionxx.prometey.domain.useCases

import com.xxlionxx.prometey.domain.repository.SecureStorageRepository

class DeleteSecureValueUseCase(
    private val secureStorageRepository: SecureStorageRepository
) {
    suspend operator fun invoke(key: String) {
        secureStorageRepository.delete(key)
    }
}