package com.xxlionxx.prometey.data.local.mapper

import com.xxlionxx.prometey.data.local.entity.UserProfileEntity
import com.xxlionxx.prometey.domain.model.UserProfile

fun UserProfileEntity.toDomain(): UserProfile {
    return UserProfile(
        userId = userId,
        displayName = displayName,
        language = language,
        timezone = timezone,
        avatarUri = avatarUri
    )
}

fun UserProfile.toEntity(): UserProfileEntity {
    return UserProfileEntity(
        userId = userId,
        displayName = displayName,
        language = language,
        timezone = timezone,
        avatarUri = avatarUri
    )
}