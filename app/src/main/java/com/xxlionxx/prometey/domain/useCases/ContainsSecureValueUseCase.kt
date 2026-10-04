package com.xxlionxx.prometey.domain.useCases

import com.xxlionxx.prometey.domain.repository.SecureStorageRepository

class ContainsSecureValueUseCase(
    private val secureStorageRepository: SecureStorageRepository
) {
    suspend operator fun invoke(key: String): Boolean {
        return secureStorageRepository.contains(key)
    }
}