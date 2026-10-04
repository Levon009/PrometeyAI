package com.xxlionxx.prometey.data.local.mapper

import com.xxlionxx.prometey.data.local.entity.AIBehaviorEntity
import com.xxlionxx.prometey.domain.model.AIBehavior

fun AIBehaviorEntity.toDomain(): AIBehavior {
    return AIBehavior(
        kindness = kindness,
        empathy = empathy,
        verbosity = verbosity,
        proactivity = proactivity
    )
}

fun AIBehavior.toEntity(): AIBehaviorEntity {
    return AIBehaviorEntity(
        kindness = kindness,
        empathy = empathy,
        verbosity = verbosity,
        proactivity = proactivity
    )
}