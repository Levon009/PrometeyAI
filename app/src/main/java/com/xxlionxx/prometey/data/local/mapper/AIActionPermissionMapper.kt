package com.xxlionxx.prometey.data.local.mapper

import com.xxlionxx.prometey.data.local.entity.AIActionPermissionEntity
import com.xxlionxx.prometey.domain.model.AIAction
import com.xxlionxx.prometey.domain.model.AIActionPermission

fun AIActionPermissionEntity.toDomain(): AIActionPermission {
    return AIActionPermission(
        action = AIAction.valueOf(action),
        isAllowed = isAllowed,
        requiresConfirmation = requiresConfirmation
    )
}

fun AIActionPermission.toEntity(): AIActionPermissionEntity {
    return AIActionPermissionEntity(
        action = action.name,
        isAllowed = isAllowed,
        requiresConfirmation = requiresConfirmation
    )
}