package com.xxlionxx.prometey.domain.useCases

import com.xxlionxx.prometey.domain.repository.AttachmentRepository

class DeleteAttachmentUseCase(
    private val attachmentRepository: AttachmentRepository
) {

    suspend operator fun invoke(id: String) {
        attachmentRepository.deleteAttachment(id)
    }
}