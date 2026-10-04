package com.xxlionxx.prometey.domain.useCases

import com.xxlionxx.prometey.domain.model.Attachment
import com.xxlionxx.prometey.domain.repository.AttachmentRepository

class SaveAttachmentUseCase(
    private val attachmentRepository: AttachmentRepository
) {

    suspend operator fun invoke(attachment: Attachment) {
        attachmentRepository.saveAttachment(attachment)
    }
}