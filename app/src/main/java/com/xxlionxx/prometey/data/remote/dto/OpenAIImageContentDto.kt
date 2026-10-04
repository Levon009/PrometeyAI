package com.xxlionxx.prometey.data.remote.dto

import com.google.gson.annotations.SerializedName

data class OpenAIImageContentDto(
    val type: String,
    val text: String? = null,

    @SerializedName("image_url")
    val imageUrl: String? = null,

    val detail: String? = null
)
