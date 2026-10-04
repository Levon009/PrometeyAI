package com.xxlionxx.prometey.data.repository

import com.xxlionxx.prometey.data.local.dao.AIBehaviorDao
import com.xxlionxx.prometey.data.local.mapper.toDomain
import com.xxlionxx.prometey.data.local.mapper.toEntity
import com.xxlionxx.prometey.domain.model.AIBehavior
import com.xxlionxx.prometey.domain.repository.AIBehaviorRepository

class AIBehaviorRepositoryImpl(
    private val dao: AIBehaviorDao
) : AIBehaviorRepository {

    override suspend fun getBehavior(): AIBehavior {
        return dao.getBehavior(1)?.toDomain()
            ?: AIBehavior(
                kindness = 0.5f,
                empathy = 0.5f,
                verbosity = 0.5f,
                proactivity = 0.5f
            )
    }

    override suspend fun saveBehavior(
        behavior: AIBehavior
    ) {
        dao.insertBehavior(
            behavior.toEntity()
        )
    }

    override suspend fun updateBehavior(
        behavior: AIBehavior
    ) {
        dao.updateBehavior(
            behavior.toEntity()
        )
    }
}