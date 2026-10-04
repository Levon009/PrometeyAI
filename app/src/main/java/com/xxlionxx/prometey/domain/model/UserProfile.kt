package com.xxlionxx.prometey.domain.model

data class UserProfile(
    val userId: String,
    val displayName: String?,
    val language: String,
    val timezone: String,
    val avatarUri: String? = null
)
