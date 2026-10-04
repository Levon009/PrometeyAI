package com.xxlionxx.prometey.data.local.entity

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "ai_action_policies")
data class AIActionPolicyEntity(
    @PrimaryKey
    val id: Int = 1,
    val allowAutomaticActions: Boolean
)
