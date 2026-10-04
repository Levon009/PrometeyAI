package com.xxlionxx.prometey.data.local.mapper

import com.xxlionxx.prometey.data.local.entity.AIInstructionEntity
import com.xxlionxx.prometey.domain.model.AIInstruction

fun AIInstructionEntity.toDomain(): AIInstruction {
    return AIInstruction(
        id = id,
        name = name,
        content = content,
        priority = priority,
        isActive = isActive
    )
}

fun AIInstruction.toEntity(): AIInstructionEntity {
    return AIInstructionEntity(
        id = id,
        name = name,
        content = content,
        priority = priority,
        isActive = isActive
    )
}