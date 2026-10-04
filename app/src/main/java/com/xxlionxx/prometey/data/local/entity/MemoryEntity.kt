package com.xxlionxx.prometey.data.local.entity

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "memories")
data class MemoryEntity(
    @PrimaryKey
    val id: String,
    val userId: String,
    val content: String,
    val type: String,
    val source: String,
    val status: String,
    val importance: String,
    val tags: String,
    val metadata: String,
    val createdAt: Long
)
