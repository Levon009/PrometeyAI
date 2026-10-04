package com.xxlionxx.prometey.domain.repository

import com.xxlionxx.prometey.domain.model.AIBehavior

interface AIBehaviorRepository {

    suspend fun getBehavior(): AIBehavior

    suspend fun saveBehavior(behavior: AIBehavior)

    suspend fun updateBehavior(behavior: AIBehavior)
}