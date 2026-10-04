package com.xxlionxx.prometey.data.local.mapper

import com.xxlionxx.prometey.data.local.entity.UserPreferenceEntity
import com.xxlionxx.prometey.domain.model.UserPreference

fun UserPreferenceEntity.toDomain(): UserPreference {
    return UserPreference(
        id = id,
        userId = userId,
        key = key,
        value = value
    )
}

fun UserPreference.toEntity(): UserPreferenceEntity {
    return UserPreferenceEntity(
        id = id,
        userId = userId,
        key = key,
        value = value
    )
}