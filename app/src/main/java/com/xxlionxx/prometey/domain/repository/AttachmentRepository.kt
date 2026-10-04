package com.xxlionxx.prometey.domain.repository

import com.xxlionxx.prometey.domain.model.Attachment

interface AttachmentRepository {

    suspend fun getAttachments(messageId: String): List<Attachment>

    suspend fun saveAttachment(attachment: Attachment)

    suspend fun deleteAttachment(id: String)
}