package com.xxlionxx.prometey.domain.repository

import com.xxlionxx.prometey.domain.model.AIAction
import com.xxlionxx.prometey.domain.model.AIActionPermission
import com.xxlionxx.prometey.domain.model.AIActionResult

interface AIActionRepository {

    suspend fun getPermission(action: AIAction): AIActionPermission

    suspend fun execute(action: AIAction, parameters: Map<String, String>): AIActionResult
}