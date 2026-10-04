package com.xxlionxx.prometey.domain.model

data class AIMessageContext(
    val conversation: Conversation,
    val message: List<Message>,
    val memories: List<Memory>,
    val userProfile: UserProfile,
    val goals: List<UserGoal>,
    val preferences: List<UserPreference>
)
