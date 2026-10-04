package com.xxlionxx.prometey.domain.model

data class ForecastSource(
    val id: String,
    val title: String,
    val url: String?,
    val publisher: String?,
    val publishedAt: Long?,
    val retrievedAt: Long
)
