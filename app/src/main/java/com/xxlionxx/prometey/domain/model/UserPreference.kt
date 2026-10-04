package com.xxlionxx.prometey.domain.model

data class UserPreference(
    val id: String,
    val userId: String,
    val key: String,
    val value: String
)
