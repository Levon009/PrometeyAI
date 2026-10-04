package com.xxlionxx.prometey.data.local.mapper

import com.xxlionxx.prometey.data.local.entity.AIModelEntity
import com.xxlionxx.prometey.domain.model.AIModel
import com.xxlionxx.prometey.domain.model.AIProvider

fun AIModelEntity.toDomain(): AIModel {
    return AIModel(
        id = id,
        provider = AIProvider.valueOf(provider),
        name = name,
        isMultimodal = isMultimodal
    )
}

fun AIModel.toEntity(): AIModelEntity {
    return AIModelEntity(
        id = id,
        provider = provider.name,
        name = name,
        isMultimodal = isMultimodal
    )
}