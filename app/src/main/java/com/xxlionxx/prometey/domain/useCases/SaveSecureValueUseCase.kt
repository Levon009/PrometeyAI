package com.xxlionxx.prometey.domain.useCases

import com.xxlionxx.prometey.domain.repository.SecureStorageRepository

class SaveSecureValueUseCase(
    private val secureStorageRepository: SecureStorageRepository
) {
    suspend operator fun invoke(
        key: String,
        value: String
    ) {
        secureStorageRepository.save(
            key = key,
            value = value
        )
    }
}