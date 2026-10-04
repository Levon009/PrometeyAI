package com.xxlionxx.prometey.data.local.entity

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "conversations")
data class ConversationEntity(
    @PrimaryKey
    val id: String,
    val userId: String,
    val title: String?,
    val status: String,
    val createdAt: Long,
    val updatedAt: Long
)
