package com.xxlionxx.prometey.domain.model

data class UserGoal(
    val id: String,
    val userId: String,
    val title: String,
    val description: String?,
    val status: GoalStatus,
    val createdAt: Long
)
