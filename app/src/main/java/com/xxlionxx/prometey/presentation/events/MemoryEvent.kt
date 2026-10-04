package com.xxlionxx.prometey.presentation.events

import com.xxlionxx.prometey.domain.model.Memory

sealed interface MemoryEvent : MviEvent {

    data class LoadMemories(
        val userId: String
    ) : MemoryEvent

    data class LoadMemory(
        val memoryId: String
    ) : MemoryEvent

    data class SaveMemory(
        val memory: Memory
    ) : MemoryEvent

    data class UpdateMemory(
        val memory: Memory
    ) : MemoryEvent

    data class DeleteMemory(
        val memoryId: String
    ) : MemoryEvent

    data class Refresh(
        val userId: String
    ) : MemoryEvent
}