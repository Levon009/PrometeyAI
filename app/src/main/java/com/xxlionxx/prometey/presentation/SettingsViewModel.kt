package com.xxlionxx.prometey.presentation

import androidx.lifecycle.viewModelScope
import com.xxlionxx.prometey.domain.useCases.ContainsSecureValueUseCase
import com.xxlionxx.prometey.domain.useCases.DeleteSecureValueUseCase
import com.xxlionxx.prometey.domain.useCases.GetAISettingsUseCase
import com.xxlionxx.prometey.domain.useCases.GetAppSettingBooleanUseCase
import com.xxlionxx.prometey.domain.useCases.GetAppSettingStringUseCase
import com.xxlionxx.prometey.domain.useCases.GetSecureValueUseCase
import com.xxlionxx.prometey.domain.useCases.RemoveAppSettingUseCase
import com.xxlionxx.prometey.domain.useCases.SaveAISettingsUseCase
import com.xxlionxx.prometey.domain.useCases.SaveSecureValueUseCase
import com.xxlionxx.prometey.domain.useCases.SetAppSettingBooleanUseCase
import com.xxlionxx.prometey.domain.useCases.SetAppSettingStringUseCase
import com.xxlionxx.prometey.domain.useCases.UpdateAISettingsUseCase
import com.xxlionxx.prometey.domain.useCases.GetAvailableAIModelsUseCase
import com.xxlionxx.prometey.presentation.events.SettingsEvent
import com.xxlionxx.prometey.presentation.states.SettingsState
import kotlinx.coroutines.launch

class SettingsViewModel(
    private val getAvailableAIModelsUseCase: GetAvailableAIModelsUseCase,
    private val getAISettingsUseCase: GetAISettingsUseCase,
    private val saveAISettingsUseCase: SaveAISettingsUseCase,
    private val updateAISettingsUseCase: UpdateAISettingsUseCase,
    private val getAppSettingBooleanUseCase: GetAppSettingBooleanUseCase,
    private val getAppSettingStringUseCase: GetAppSettingStringUseCase,
    private val setAppSettingBooleanUseCase: SetAppSettingBooleanUseCase,
    private val setAppSettingStringUseCase: SetAppSettingStringUseCase,
    private val removeAppSettingUseCase: RemoveAppSettingUseCase,
    private val containsSecureValueUseCase: ContainsSecureValueUseCase,
    private val getSecureValueUseCase: GetSecureValueUseCase,
    private val saveSecureValueUseCase: SaveSecureValueUseCase,
    private val deleteSecureValueUseCase: DeleteSecureValueUseCase
) : MviViewModel<SettingsEvent, SettingsState>(SettingsState()) {

    override fun onEvent(event: SettingsEvent) {
        when (event) {
            SettingsEvent.LoadAvailableAIModels ->
                loadAvailableAIModels()

            SettingsEvent.LoadAISettings ->
                loadAISettings()

            is SettingsEvent.SaveAISettings ->
                saveAISettings(event.settings)

            is SettingsEvent.UpdateAISettings ->
                updateAISettings(event.settings)

            is SettingsEvent.LoadBooleanSetting ->
                loadBooleanSetting(event.key)

            is SettingsEvent.SetBooleanSetting ->
                setBooleanSetting(
                    key = event.key,
                    value = event.value
                )

            is SettingsEvent.LoadStringSetting ->
                loadStringSetting(event.key)

            is SettingsEvent.SetStringSetting ->
                setStringSetting(
                    key = event.key,
                    value = event.value
                )

            is SettingsEvent.RemoveAppSetting ->
                removeAppSetting(event.key)

            is SettingsEvent.CheckSecureValue ->
                checkSecureValue(event.key)

            is SettingsEvent.LoadSecureValue ->
                loadSecureValue(event.key)

            is SettingsEvent.SaveSecureValue ->
                saveSecureValue(
                    key = event.key,
                    value = event.value
                )

            is SettingsEvent.DeleteSecureValue ->
                deleteSecureValue(event.key)

            SettingsEvent.ClearSettings ->
                updateState {
                    SettingsState()
                }
        }
    }

    private fun loadAvailableAIModels() {
        viewModelScope.launch {
            updateState {
                it.copy(
                    isLoading = true,
                    error = null
                )
            }

            try {
                val models = getAvailableAIModelsUseCase()

                updateState {
                    it.copy(
                        availableAIModels = models,
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

    private fun loadAISettings() {
        viewModelScope.launch {
            updateState {
                it.copy(
                    isLoading = true,
                    error = null
                )
            }

            try {
                val settings = getAISettingsUseCase()

                updateState {
                    it.copy(
                        aiSettings = settings,
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

    private fun saveAISettings(
        settings: com.xxlionxx.prometey.domain.model.AISettings
    ) {
        viewModelScope.launch {
            updateState {
                it.copy(
                    isSaving = true,
                    error = null
                )
            }

            try {
                saveAISettingsUseCase(settings)

                updateState {
                    it.copy(
                        aiSettings = settings,
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

    private fun updateAISettings(
        settings: com.xxlionxx.prometey.domain.model.AISettings
    ) {
        viewModelScope.launch {
            updateState {
                it.copy(
                    isSaving = true,
                    error = null
                )
            }

            try {
                updateAISettingsUseCase(settings)

                updateState {
                    it.copy(
                        aiSettings = settings,
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

    private fun loadBooleanSetting(key: String) {
        viewModelScope.launch {
            updateState {
                it.copy(
                    isLoading = true,
                    error = null
                )
            }

            try {
                val value = getAppSettingBooleanUseCase(key)

                updateState {
                    it.copy(
                        booleanSettings = it.booleanSettings + (key to value),
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

    private fun setBooleanSetting(
        key: String,
        value: Boolean
    ) {
        viewModelScope.launch {
            updateState {
                it.copy(
                    isSaving = true,
                    error = null
                )
            }

            try {
                setAppSettingBooleanUseCase(key, value)

                updateState {
                    it.copy(
                        booleanSettings = it.booleanSettings + (key to value),
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

    private fun loadStringSetting(key: String) {
        viewModelScope.launch {
            updateState {
                it.copy(
                    isLoading = true,
                    error = null
                )
            }

            try {
                val value = getAppSettingStringUseCase(key)

                updateState {
                    it.copy(
                        stringSettings = it.stringSettings + (key to value),
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

    private fun setStringSetting(
        key: String,
        value: String
    ) {
        viewModelScope.launch {
            updateState {
                it.copy(
                    isSaving = true,
                    error = null
                )
            }

            try {
                setAppSettingStringUseCase(key, value)

                updateState {
                    it.copy(
                        stringSettings = it.stringSettings + (key to value),
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

    private fun removeAppSetting(key: String) {
        viewModelScope.launch {
            updateState {
                it.copy(
                    isDeleting = true,
                    error = null
                )
            }

            try {
                removeAppSettingUseCase(key)

                updateState {
                    it.copy(
                        booleanSettings = it.booleanSettings - key,
                        stringSettings = it.stringSettings - key,
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

    private fun checkSecureValue(key: String) {
        viewModelScope.launch {
            updateState {
                it.copy(
                    isLoading = true,
                    error = null
                )
            }

            try {
                val exists = containsSecureValueUseCase(key)

                updateState {
                    it.copy(
                        secureValuePresence = it.secureValuePresence + (key to exists),
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

    private fun loadSecureValue(key: String) {
        viewModelScope.launch {
            updateState {
                it.copy(
                    isLoading = true,
                    error = null
                )
            }

            try {
                val value = getSecureValueUseCase(key)

                updateState {
                    it.copy(
                        secureValues = it.secureValues + (key to value),
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

    private fun saveSecureValue(
        key: String,
        value: String
    ) {
        viewModelScope.launch {
            updateState {
                it.copy(
                    isSaving = true,
                    error = null
                )
            }

            try {
                saveSecureValueUseCase(key, value)

                updateState {
                    it.copy(
                        secureValues = it.secureValues + (key to value),
                        secureValuePresence = it.secureValuePresence + (key to true),
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

    private fun deleteSecureValue(key: String) {
        viewModelScope.launch {
            updateState {
                it.copy(
                    isDeleting = true,
                    error = null
                )
            }

            try {
                deleteSecureValueUseCase(key)

                updateState {
                    it.copy(
                        secureValues = it.secureValues - key,
                        secureValuePresence = it.secureValuePresence + (key to false),
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