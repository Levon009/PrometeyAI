package com.xxlionxx.prometey.data.local.mapper

import com.xxlionxx.prometey.data.local.entity.MessageEntity
import com.xxlionxx.prometey.domain.model.Attachment
import com.xxlionxx.prometey.domain.model.Message
import com.xxlionxx.prometey.domain.model.MessageRole

fun MessageEntity.toDomain(
    attachments: List<Attachment>
): Message {
    return Message(
        id = id,
        conversationId = conversationId,
        role = MessageRole.valueOf(role),
        content = content,
        attachments = attachments,
        createdAt = createdAt
    )
}

fun Message.toEntity(): MessageEntity {
    return MessageEntity(
        id = id,
        conversationId = conversationId,
        role = role.name,
        content = content,
        createdAt = createdAt
    )
}