package com.xxlionxx.prometey.domain.model

data class Memory(
    val id: String,
    val userId: String,
    val content: String,
    val type: MemoryType,
    val source: MemorySource,
    val status: MemoryStatus,
    val importance: MemoryImportance,
    val tags: List<MemoryTag>,
    val metadata: MemoryMetadata,
    val createdAt: Long
)
