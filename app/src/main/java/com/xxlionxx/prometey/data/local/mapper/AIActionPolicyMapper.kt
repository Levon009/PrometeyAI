package com.xxlionxx.prometey.data.local.mapper

import com.xxlionxx.prometey.data.local.entity.AIActionPolicyEntity
import com.xxlionxx.prometey.domain.model.AIActionPermission
import com.xxlionxx.prometey.domain.model.AIActionPolicy

fun AIActionPolicyEntity.toDomain(
    permissions: List<AIActionPermission>
): AIActionPolicy {
    return AIActionPolicy(
        permissions = permissions,
        allowAutomaticActions = allowAutomaticActions
    )
}

fun AIActionPolicy.toEntity(): AIActionPolicyEntity {
    return AIActionPolicyEntity(
        allowAutomaticActions = allowAutomaticActions
    )
}