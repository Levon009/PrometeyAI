package com.xxlionxx.prometey.data.local.entity

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "ai_action_permissions")
data class AIActionPermissionEntity(
    @PrimaryKey
    @ColumnInfo(name = "action_name")
    val action: String,
    val isAllowed: Boolean,
    val requiresConfirmation: Boolean
)
