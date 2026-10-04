package com.xxlionxx.prometey.data.local.mapper

import com.xxlionxx.prometey.data.local.entity.ConversationEntity
import com.xxlionxx.prometey.domain.model.Conversation
import com.xxlionxx.prometey.domain.model.ConversationStatus

fun ConversationEntity.toDomain(): Conversation {
    return Conversation(
        id = id,
        userId = userId,
        title = title,
        status = ConversationStatus.valueOf(status),
        createdAt = createdAt,
        updatedAt = updatedAt
    )
}

fun Conversation.toEntity(): ConversationEntity {
    return ConversationEntity(
        id = id,
        userId = userId,
        title = title,
        status = status.name,
        createdAt = createdAt,
        updatedAt = updatedAt
    )
}