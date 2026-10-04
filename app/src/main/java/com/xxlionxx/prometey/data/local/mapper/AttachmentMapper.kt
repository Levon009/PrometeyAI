package com.xxlionxx.prometey.data.local.mapper

import com.xxlionxx.prometey.data.local.entity.AttachmentEntity
import com.xxlionxx.prometey.domain.model.Attachment
import com.xxlionxx.prometey.domain.model.AttachmentType

fun AttachmentEntity.toDomain(): Attachment {
    return Attachment(
        id = id,
        messageId = messageId,
        type = AttachmentType.valueOf(type),
        uri = uri
    )
}

fun Attachment.toEntity(): AttachmentEntity {
    return AttachmentEntity(
        id = id,
        messageId = messageId,
        type = type.name,
        uri = uri
    )
}