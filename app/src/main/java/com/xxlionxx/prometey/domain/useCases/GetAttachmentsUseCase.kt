package com.xxlionxx.prometey.domain.useCases

import com.xxlionxx.prometey.domain.model.Attachment
import com.xxlionxx.prometey.domain.repository.AttachmentRepository

class GetAttachmentsUseCase(
    private val attachmentRepository: AttachmentRepository
) {

    suspend operator fun invoke(messageId: String): List<Attachment> {
        return attachmentRepository.getAttachments(messageId)
    }
}