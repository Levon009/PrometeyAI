package com.xxlionxx.prometey.data.local.mapper

import com.google.gson.Gson
import com.google.gson.reflect.TypeToken
import com.xxlionxx.prometey.data.local.entity.MemoryEntity
import com.xxlionxx.prometey.domain.model.Memory
import com.xxlionxx.prometey.domain.model.MemoryImportance
import com.xxlionxx.prometey.domain.model.MemoryMetadata
import com.xxlionxx.prometey.domain.model.MemorySource
import com.xxlionxx.prometey.domain.model.MemoryStatus
import com.xxlionxx.prometey.domain.model.MemoryTag
import com.xxlionxx.prometey.domain.model.MemoryType

private val gson = Gson()

fun MemoryEntity.toDomain(): Memory {
    val tagType = object : TypeToken<List<MemoryTag>>() {}.type

    return Memory(
        id = id,
        userId = userId,
        content = content,
        type = MemoryType.valueOf(type),
        source = MemorySource.valueOf(source),
        status = MemoryStatus.valueOf(status),
        importance = MemoryImportance.valueOf(importance),
        tags = gson.fromJson(tags, tagType),
        metadata = gson.fromJson(metadata, MemoryMetadata::class.java),
        createdAt = createdAt
    )
}

fun Memory.toEntity(): MemoryEntity {
    return MemoryEntity(
        id = id,
        userId = userId,
        content = content,
        type = type.name,
        source = source.name,
        status = status.name,
        importance = importance.name,
        tags = gson.toJson(tags),
        metadata = gson.toJson(metadata),
        createdAt = createdAt
    )
}