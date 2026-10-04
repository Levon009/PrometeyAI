package com.xxlionxx.prometey.data.repository

import com.xxlionxx.prometey.data.local.dao.AIActionPermissionDao
import com.xxlionxx.prometey.data.local.mapper.toDomain
import com.xxlionxx.prometey.domain.model.AIAction
import com.xxlionxx.prometey.domain.model.AIActionPermission
import com.xxlionxx.prometey.domain.model.AIActionResult
import com.xxlionxx.prometey.domain.repository.AIActionRepository

class AIActionRepositoryImpl(
    private val permissionDao: AIActionPermissionDao
) : AIActionRepository {

    override suspend fun getPermission(
        action: AIAction
    ): AIActionPermission {
        return permissionDao.getPermission(action.name)
            ?.toDomain()
            ?: AIActionPermission(
                action = action,
                isAllowed = false,
                requiresConfirmation = true
            )
    }

    override suspend fun execute(
        action: AIAction,
        parameters: Map<String, String>
    ): AIActionResult {
        return AIActionResult(
            action = action,
            success = false,
            message = "Action execution is not implemented yet."
        )
    }
}