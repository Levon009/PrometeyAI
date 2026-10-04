package com.xxlionxx.prometey.domain.model

data class Attachment(
    val id: String,
    val messageId: String,
    val type: AttachmentType,
    val uri: String
)
