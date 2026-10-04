package com.xxlionxx.prometey.data.local.mapper

import com.xxlionxx.prometey.data.local.entity.UserEntity
import com.xxlionxx.prometey.domain.model.User

fun UserEntity.toDomain(): User {
    return User(
        id = id,
        name = name
    )
}

fun User.toEntity(): UserEntity {
    return UserEntity(
        id = id,
        name = name
    )
}