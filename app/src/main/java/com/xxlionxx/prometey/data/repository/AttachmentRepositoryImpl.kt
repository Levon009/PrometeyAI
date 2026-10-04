package com.xxlionxx.prometey.data.repository

import com.xxlionxx.prometey.data.local.dao.AttachmentDao
import com.xxlionxx.prometey.data.local.mapper.toDomain
import com.xxlionxx.prometey.data.local.mapper.toEntity
import com.xxlionxx.prometey.domain.model.Attachment
import com.xxlionxx.prometey.domain.repository.AttachmentRepository

class AttachmentRepositoryImpl(
    private val dao: AttachmentDao
) : AttachmentRepository {

    override suspend fun getAttachments(
        messageId: String
    ): List<Attachment> {
        return dao.getAttachments(messageId)
            .map { it.toDomain() }
    }

    override suspend fun saveAttachment(
        attachment: Attachment
    ) {
        dao.insertAttachment(
            attachment.toEntity()
        )
    }

    override suspend fun deleteAttachment(
        id: String
    ) {
        val attachment = dao.getAttachmentById(id)
            ?: return

        dao.deleteAttachment(attachment)
    }
}