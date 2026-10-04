package com.xxlionxx.prometey.data.local.mapper

import com.xxlionxx.prometey.data.local.entity.UserGoalEntity
import com.xxlionxx.prometey.domain.model.GoalStatus
import com.xxlionxx.prometey.domain.model.UserGoal

fun UserGoalEntity.toDomain(): UserGoal {
    return UserGoal(
        id = id,
        userId = userId,
        title = title,
        description = description,
        status = GoalStatus.valueOf(status),
        createdAt = createdAt
    )
}

fun UserGoal.toEntity(): UserGoalEntity {
    return UserGoalEntity(
        id = id,
        userId = userId,
        title = title,
        description = description,
        status = status.name,
        createdAt = createdAt
    )
}