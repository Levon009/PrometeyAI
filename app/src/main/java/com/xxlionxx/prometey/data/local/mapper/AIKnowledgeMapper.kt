package com.xxlionxx.prometey.data.local.mapper

import com.xxlionxx.prometey.data.local.entity.AIKnowledgeEntity
import com.xxlionxx.prometey.domain.model.AIKnowledge
import com.xxlionxx.prometey.domain.model.AIKnowledgeSource
import com.xxlionxx.prometey.domain.model.AIKnowledgeStatus

fun AIKnowledgeEntity.toDomain(): AIKnowledge {
    return AIKnowledge(
        id = id,
        topic = topic,
        content = content,
        source = AIKnowledgeSource.valueOf(source),
        status = AIKnowledgeStatus.valueOf(status),
        confidence = confidence,
        createdAt = createdAt,
        updatedAt = updatedAt
    )
}

fun AIKnowledge.toEntity(): AIKnowledgeEntity {
    return AIKnowledgeEntity(
        id = id,
        topic = topic,
        content = content,
        source = source.name,
        status = status.name,
        confidence = confidence,
        createdAt = createdAt,
        updatedAt = updatedAt
    )
}