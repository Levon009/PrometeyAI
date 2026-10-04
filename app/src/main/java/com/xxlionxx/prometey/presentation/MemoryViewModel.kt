package com.xxlionxx.prometey.presentation

import androidx.lifecycle.viewModelScope
import com.xxlionxx.prometey.domain.useCases.DeleteMemoryUseCase
import com.xxlionxx.prometey.domain.useCases.GetMemoriesUseCase
import com.xxlionxx.prometey.domain.useCases.GetMemoryByIdUseCase
import com.xxlionxx.prometey.domain.useCases.SaveMemoryUseCase
import com.xxlionxx.prometey.domain.useCases.UpdateMemoryUseCase
import com.xxlionxx.prometey.presentation.events.MemoryEvent
import com.xxlionxx.prometey.presentation.states.MemoryState
import kotlinx.coroutines.launch

class MemoryViewModel(
    private val getMemoriesUseCase: GetMemoriesUseCase,
    private val getMemoryByIdUseCase: GetMemoryByIdUseCase,
    private val saveMemoryUseCase: SaveMemoryUseCase,
    private val updateMemoryUseCase: UpdateMemoryUseCase,
    private val deleteMemoryUseCase: DeleteMemoryUseCase
) : MviViewModel<MemoryEvent, MemoryState>(MemoryState()) {

    override fun onEvent(event: MemoryEvent) {
        when (event) {
            is MemoryEvent.LoadMemories -> {
                loadMemories(event.userId)
            }

            is MemoryEvent.LoadMemory -> {
                loadMemory(event.memoryId)
            }

            is MemoryEvent.SaveMemory -> {
                saveMemory(event.memory)
            }

            is MemoryEvent.UpdateMemory -> {
                updateMemory(event.memory)
            }

            is MemoryEvent.DeleteMemory -> {
                deleteMemory(event.memoryId)
            }

            is MemoryEvent.Refresh -> {
                loadMemories(event.userId)
            }
        }
    }

    private fun loadMemories(userId: String) {
        viewModelScope.launch {
            updateState {
                it.copy(
                    isLoading = true,
                    error = null
                )
            }

            try {
                val memories = getMemoriesUseCase(userId)

                updateState {
                    it.copy(
                        memories = memories,
                        isLoading = false,
                        error = null
                    )
                }
            } catch (exception: Exception) {
                updateState {
                    it.copy(
                        isLoading = false,
                        error = exception.message
                    )
                }
            }
        }
    }

    private fun loadMemory(memoryId: String) {
        viewModelScope.launch {
            updateState {
                it.copy(
                    isLoading = true,
                    error = null
                )
            }

            try {
                val memory = getMemoryByIdUseCase(memoryId)

                updateState {
                    it.copy(
                        selectedMemory = memory,
                        isLoading = false,
                        error = null
                    )
                }
            } catch (exception: Exception) {
                updateState {
                    it.copy(
                        isLoading = false,
                        error = exception.message
                    )
                }
            }
        }
    }

    private fun saveMemory(memory: com.xxlionxx.prometey.domain.model.Memory) {
        viewModelScope.launch {
            updateState {
                it.copy(
                    isSaving = true,
                    error = null
                )
            }

            try {
                saveMemoryUseCase(memory)

                updateState {
                    it.copy(
                        memories = it.memories
                            .filterNot { existing -> existing.id == memory.id } + memory,
                        selectedMemory = memory,
                        isSaving = false,
                        error = null
                    )
                }
            } catch (exception: Exception) {
                updateState {
                    it.copy(
                        isSaving = false,
                        error = exception.message
                    )
                }
            }
        }
    }

    private fun updateMemory(memory: com.xxlionxx.prometey.domain.model.Memory) {
        viewModelScope.launch {
            updateState {
                it.copy(
                    isSaving = true,
                    error = null
                )
            }

            try {
                updateMemoryUseCase(memory)

                updateState {
                    it.copy(
                        memories = it.memories.map { existing ->
                            if (existing.id == memory.id) memory else existing
                        },
                        selectedMemory = memory,
                        isSaving = false,
                        error = null
                    )
                }
            } catch (exception: Exception) {
                updateState {
                    it.copy(
                        isSaving = false,
                        error = exception.message
                    )
                }
            }
        }
    }

    private fun deleteMemory(memoryId: String) {
        viewModelScope.launch {
            updateState {
                it.copy(
                    isDeleting = true,
                    error = null
                )
            }

            try {
                deleteMemoryUseCase(memoryId)

                updateState {
                    it.copy(
                        memories = it.memories.filterNot { memory ->
                            memory.id == memoryId
                        },
                        selectedMemory = if (it.selectedMemory?.id == memoryId) {
                            null
                        } else {
                            it.selectedMemory
                        },
                        isDeleting = false,
                        error = null
                    )
                }
            } catch (exception: Exception) {
                updateState {
                    it.copy(
                        isDeleting = false,
                        error = exception.message
                    )
                }
            }
        }
    }
}