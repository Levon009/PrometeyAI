package com.xxlionxx.prometey.presentation

import androidx.lifecycle.viewModelScope
import com.xxlionxx.prometey.domain.model.AIAction
import com.xxlionxx.prometey.domain.model.AIBehavior
import com.xxlionxx.prometey.domain.model.AIInstruction
import com.xxlionxx.prometey.domain.model.AIKnowledge
import com.xxlionxx.prometey.domain.model.AISettings
import com.xxlionxx.prometey.domain.model.AIActionPolicy
import com.xxlionxx.prometey.domain.useCases.DeleteAIInstructionUseCase
import com.xxlionxx.prometey.domain.useCases.DeleteAIKnowledgeUseCase
import com.xxlionxx.prometey.domain.useCases.ExecuteAIActionUseCase
import com.xxlionxx.prometey.domain.useCases.GetAIActionPermissionUseCase
import com.xxlionxx.prometey.domain.useCases.GetAIActionPolicyUseCase
import com.xxlionxx.prometey.domain.useCases.GetAIBehaviorUseCase
import com.xxlionxx.prometey.domain.useCases.GetAIKnowledgeByIdUseCase
import com.xxlionxx.prometey.domain.useCases.GetAIKnowledgeUseCase
import com.xxlionxx.prometey.domain.useCases.GetAIModelByIdUseCase
import com.xxlionxx.prometey.domain.useCases.GetAISettingsUseCase
import com.xxlionxx.prometey.domain.useCases.GetActiveAIInstructionsUseCase
import com.xxlionxx.prometey.domain.useCases.GetAvailableAIModelsUseCase
import com.xxlionxx.prometey.domain.useCases.SaveAIActionPolicyUseCase
import com.xxlionxx.prometey.domain.useCases.SaveAIBehaviorUseCase
import com.xxlionxx.prometey.domain.useCases.SaveAIInstructionUseCase
import com.xxlionxx.prometey.domain.useCases.SaveAIKnowledgeUseCase
import com.xxlionxx.prometey.domain.useCases.SaveAISettingsUseCase
import com.xxlionxx.prometey.domain.useCases.UpdateAIActionPolicyUseCase
import com.xxlionxx.prometey.domain.useCases.UpdateAIBehaviorUseCase
import com.xxlionxx.prometey.domain.useCases.UpdateAIInstructionUseCase
import com.xxlionxx.prometey.domain.useCases.UpdateAIKnowledgeUseCase
import com.xxlionxx.prometey.domain.useCases.UpdateAISettingsUseCase
import com.xxlionxx.prometey.presentation.events.AIEvent
import com.xxlionxx.prometey.presentation.states.AIState
import kotlinx.coroutines.launch

class AIViewModel(
    private val getAIBehaviorUseCase: GetAIBehaviorUseCase,
    private val saveAIBehaviorUseCase: SaveAIBehaviorUseCase,
    private val updateAIBehaviorUseCase: UpdateAIBehaviorUseCase,

    private val getActiveAIInstructionsUseCase: GetActiveAIInstructionsUseCase,
    private val saveAIInstructionUseCase: SaveAIInstructionUseCase,
    private val updateAIInstructionUseCase: UpdateAIInstructionUseCase,
    private val deleteAIInstructionUseCase: DeleteAIInstructionUseCase,

    private val getAIKnowledgeUseCase: GetAIKnowledgeUseCase,
    private val getAIKnowledgeByIdUseCase: GetAIKnowledgeByIdUseCase,
    private val saveAIKnowledgeUseCase: SaveAIKnowledgeUseCase,
    private val updateAIKnowledgeUseCase: UpdateAIKnowledgeUseCase,
    private val deleteAIKnowledgeUseCase: DeleteAIKnowledgeUseCase,

    private val getAvailableAIModelsUseCase: GetAvailableAIModelsUseCase,
    private val getAIModelByIdUseCase: GetAIModelByIdUseCase,

    private val getAISettingsUseCase: GetAISettingsUseCase,
    private val saveAISettingsUseCase: SaveAISettingsUseCase,
    private val updateAISettingsUseCase: UpdateAISettingsUseCase,

    private val getAIActionPolicyUseCase: GetAIActionPolicyUseCase,
    private val saveAIActionPolicyUseCase: SaveAIActionPolicyUseCase,
    private val updateAIActionPolicyUseCase: UpdateAIActionPolicyUseCase,

    private val getAIActionPermissionUseCase: GetAIActionPermissionUseCase,
    private val executeAIActionUseCase: ExecuteAIActionUseCase
) : MviViewModel<AIEvent, AIState>(AIState()) {

    override fun onEvent(event: AIEvent) {
        when (event) {
            AIEvent.LoadBehavior -> loadBehavior()
            is AIEvent.SaveBehavior -> saveBehavior(event.behavior)
            is AIEvent.UpdateBehavior -> updateBehavior(event.behavior)

            AIEvent.LoadActiveInstructions -> loadActiveInstructions()
            is AIEvent.SaveInstruction -> saveInstruction(event.instruction)
            is AIEvent.UpdateInstruction -> updateInstruction(event.instruction)
            is AIEvent.DeleteInstruction -> deleteInstruction(event.instructionId)

            is AIEvent.LoadKnowledge -> loadKnowledge(event.topic)
            is AIEvent.LoadKnowledgeById -> loadKnowledgeById(event.knowledgeId)
            is AIEvent.SaveKnowledge -> saveKnowledge(event.knowledge)
            is AIEvent.UpdateKnowledge -> updateKnowledge(event.knowledge)
            is AIEvent.DeleteKnowledge -> deleteKnowledge(event.knowledgeId)

            AIEvent.LoadAvailableModels -> loadAvailableModels()
            is AIEvent.LoadModel -> loadModel(event.modelId)

            AIEvent.LoadSettings -> loadSettings()
            is AIEvent.SaveSettings -> saveSettings(event.settings)
            is AIEvent.UpdateSettings -> updateSettings(event.settings)

            AIEvent.LoadActionPolicy -> loadActionPolicy()
            is AIEvent.SaveActionPolicy -> saveActionPolicy(event.policy)
            is AIEvent.UpdateActionPolicy -> updateActionPolicy(event.policy)

            is AIEvent.GetActionPermission -> getActionPermission(event.action)
            is AIEvent.ExecuteAction -> executeAction(event.action, event.parameters)

            AIEvent.ClearAIState -> updateState { AIState() }
        }
    }

    private fun loadBehavior() {
        viewModelScope.launch {
            updateState { it.copy(isLoading = true, error = null) }

            try {
                val behavior = getAIBehaviorUseCase()

                updateState {
                    it.copy(
                        behavior = behavior,
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

    private fun saveBehavior(behavior: AIBehavior) {
        viewModelScope.launch {
            updateState { it.copy(isSaving = true, error = null) }

            try {
                saveAIBehaviorUseCase(behavior)

                updateState {
                    it.copy(
                        behavior = behavior,
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

    private fun updateBehavior(behavior: AIBehavior) {
        viewModelScope.launch {
            updateState { it.copy(isSaving = true, error = null) }

            try {
                updateAIBehaviorUseCase(behavior)

                updateState {
                    it.copy(
                        behavior = behavior,
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

    private fun loadActiveInstructions() {
        viewModelScope.launch {
            updateState { it.copy(isLoading = true, error = null) }

            try {
                val instructions = getActiveAIInstructionsUseCase()

                updateState {
                    it.copy(
                        activeInstructions = instructions,
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

    private fun saveInstruction(instruction: AIInstruction) {
        viewModelScope.launch {
            updateState { it.copy(isSaving = true, error = null) }

            try {
                saveAIInstructionUseCase(instruction)

                updateState {
                    it.copy(
                        activeInstructions = it.activeInstructions + instruction,
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

    private fun updateInstruction(instruction: AIInstruction) {
        viewModelScope.launch {
            updateState { it.copy(isSaving = true, error = null) }

            try {
                updateAIInstructionUseCase(instruction)

                updateState {
                    it.copy(
                        activeInstructions = it.activeInstructions.map {
                                existing ->
                            if (existing.id == instruction.id) {
                                instruction
                            } else {
                                existing
                            }
                        },
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

    private fun deleteInstruction(instructionId: String) {
        viewModelScope.launch {
            updateState { it.copy(isDeleting = true, error = null) }

            try {
                deleteAIInstructionUseCase(instructionId)

                updateState {
                    it.copy(
                        activeInstructions = it.activeInstructions.filterNot {
                            it.id == instructionId
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

    private fun loadKnowledge(topic: String) {
        viewModelScope.launch {
            updateState { it.copy(isLoading = true, error = null) }

            try {
                val knowledge = getAIKnowledgeUseCase(topic)

                updateState {
                    it.copy(
                        knowledge = knowledge,
                        selectedKnowledge = null,
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

    private fun loadKnowledgeById(knowledgeId: String) {
        viewModelScope.launch {
            updateState { it.copy(isLoading = true, error = null) }

            try {
                val knowledge = getAIKnowledgeByIdUseCase(knowledgeId)

                updateState {
                    it.copy(
                        selectedKnowledge = knowledge,
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

    private fun saveKnowledge(knowledge: AIKnowledge) {
        viewModelScope.launch {
            updateState { it.copy(isSaving = true, error = null) }

            try {
                saveAIKnowledgeUseCase(knowledge)

                updateState {
                    it.copy(
                        knowledge = it.knowledge + knowledge,
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

    private fun updateKnowledge(knowledge: AIKnowledge) {
        viewModelScope.launch {
            updateState { it.copy(isSaving = true, error = null) }

            try {
                updateAIKnowledgeUseCase(knowledge)

                updateState {
                    it.copy(
                        knowledge = it.knowledge.map {
                                existing ->
                            if (existing.id == knowledge.id) {
                                knowledge
                            } else {
                                existing
                            }
                        },
                        selectedKnowledge =
                            if (it.selectedKnowledge?.id == knowledge.id) {
                                knowledge
                            } else {
                                it.selectedKnowledge
                            },
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

    private fun deleteKnowledge(knowledgeId: String) {
        viewModelScope.launch {
            updateState { it.copy(isDeleting = true, error = null) }

            try {
                deleteAIKnowledgeUseCase(knowledgeId)

                updateState {
                    it.copy(
                        knowledge = it.knowledge.filterNot {
                            it.id == knowledgeId
                        },
                        selectedKnowledge =
                            if (it.selectedKnowledge?.id == knowledgeId) {
                                null
                            } else {
                                it.selectedKnowledge
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

    private fun loadAvailableModels() {
        viewModelScope.launch {
            updateState { it.copy(isLoading = true, error = null) }

            try {
                val models = getAvailableAIModelsUseCase()

                updateState {
                    it.copy(
                        availableModels = models,
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

    private fun loadModel(modelId: String) {
        viewModelScope.launch {
            updateState { it.copy(isLoading = true, error = null) }

            try {
                val model = getAIModelByIdUseCase(modelId)

                updateState {
                    it.copy(
                        selectedModel = model,
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

    private fun loadSettings() {
        viewModelScope.launch {
            updateState { it.copy(isLoading = true, error = null) }

            try {
                val settings = getAISettingsUseCase()

                updateState {
                    it.copy(
                        settings = settings,
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

    private fun saveSettings(settings: AISettings) {
        viewModelScope.launch {
            updateState { it.copy(isSaving = true, error = null) }

            try {
                saveAISettingsUseCase(settings)

                updateState {
                    it.copy(
                        settings = settings,
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

    private fun updateSettings(settings: AISettings) {
        viewModelScope.launch {
            updateState { it.copy(isSaving = true, error = null) }

            try {
                updateAISettingsUseCase(settings)

                updateState {
                    it.copy(
                        settings = settings,
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

    private fun loadActionPolicy() {
        viewModelScope.launch {
            updateState { it.copy(isLoading = true, error = null) }

            try {
                val policy = getAIActionPolicyUseCase()

                updateState {
                    it.copy(
                        actionPolicy = policy,
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

    private fun saveActionPolicy(policy: AIActionPolicy) {
        viewModelScope.launch {
            updateState { it.copy(isSaving = true, error = null) }

            try {
                saveAIActionPolicyUseCase(policy)

                updateState {
                    it.copy(
                        actionPolicy = policy,
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

    private fun updateActionPolicy(policy: AIActionPolicy) {
        viewModelScope.launch {
            updateState { it.copy(isSaving = true, error = null) }

            try {
                updateAIActionPolicyUseCase(policy)

                updateState {
                    it.copy(
                        actionPolicy = policy,
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

    private fun getActionPermission(action: AIAction) {
        viewModelScope.launch {
            updateState { it.copy(isLoading = true, error = null) }

            try {
                val permission = getAIActionPermissionUseCase(action)

                updateState {
                    it.copy(
                        actionPermission = permission,
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

    private fun executeAction(
        action: AIAction,
        parameters: Map<String, String>
    ) {
        viewModelScope.launch {
            updateState {
                it.copy(
                    isExecutingAction = true,
                    error = null
                )
            }

            try {
                val result = executeAIActionUseCase(
                    action = action,
                    parameters = parameters
                )

                updateState {
                    it.copy(
                        lastActionResult = result,
                        isExecutingAction = false,
                        error = null
                    )
                }
            } catch (exception: Exception) {
                updateState {
                    it.copy(
                        isExecutingAction = false,
                        error = exception.message
                    )
                }
            }
        }
    }
}