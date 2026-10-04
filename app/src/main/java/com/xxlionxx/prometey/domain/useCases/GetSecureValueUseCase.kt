package com.xxlionxx.prometey.domain.useCases

import com.xxlionxx.prometey.domain.repository.SecureStorageRepository

class GetSecureValueUseCase(
    private val secureStorageRepository: SecureStorageRepository
) {
    suspend operator fun invoke(key: String): String? {
        return secureStorageRepository.get(key)
    }
}