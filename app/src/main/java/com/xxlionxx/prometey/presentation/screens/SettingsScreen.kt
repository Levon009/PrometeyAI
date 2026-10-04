package com.xxlionxx.prometey.presentation.screens

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.verticalScroll
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.automirrored.filled.ArrowBack
import androidx.compose.material.icons.filled.Visibility
import androidx.compose.material.icons.filled.VisibilityOff
import androidx.compose.material3.Button
import androidx.compose.material3.CircularProgressIndicator
import androidx.compose.material3.DropdownMenu
import androidx.compose.material3.DropdownMenuItem
import androidx.compose.material3.HorizontalDivider
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Slider
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableFloatStateOf
import androidx.compose.runtime.mutableIntStateOf
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.input.PasswordVisualTransformation
import androidx.compose.ui.text.input.VisualTransformation
import androidx.compose.ui.unit.dp
import androidx.lifecycle.compose.collectAsStateWithLifecycle
import com.xxlionxx.prometey.domain.model.AISettings
import com.xxlionxx.prometey.presentation.SettingsViewModel
import com.xxlionxx.prometey.presentation.events.SettingsEvent
import com.xxlionxx.prometey.ui.theme.LocalAppColors
import org.koin.androidx.compose.koinViewModel
import kotlin.math.roundToInt

private const val OPENAI_API_KEY = "openai_api_key"
private const val GEMINI_API_KEY = "gemini_api_key"

@Composable
fun SettingsScreen(
    onBack: () -> Unit = {},
    viewModel: SettingsViewModel = koinViewModel()
) {
    val state by viewModel.state.collectAsStateWithLifecycle()
    val colors = LocalAppColors.current

    var selectedModelId by remember { mutableStateOf<String?>(null) }
    var temperature by remember { mutableFloatStateOf(0.7f) }
    var maxTokens by remember { mutableIntStateOf(4096) }

    var modelMenuExpanded by remember { mutableStateOf(false) }

    var openAIKey by remember { mutableStateOf("") }
    var openAIKeyVisible by remember { mutableStateOf(false) }

    var geminiKey by remember { mutableStateOf("") }
    var geminiKeyVisible by remember { mutableStateOf(false) }

    LaunchedEffect(Unit) {
        viewModel.onEvent(SettingsEvent.LoadAvailableAIModels)
        viewModel.onEvent(SettingsEvent.LoadAISettings)

        viewModel.onEvent(
            SettingsEvent.LoadSecureValue(OPENAI_API_KEY)
        )

        viewModel.onEvent(
            SettingsEvent.CheckSecureValue(OPENAI_API_KEY)
        )

        viewModel.onEvent(
            SettingsEvent.LoadSecureValue(GEMINI_API_KEY)
        )

        viewModel.onEvent(
            SettingsEvent.CheckSecureValue(GEMINI_API_KEY)
        )
    }

    LaunchedEffect(state.aiSettings) {
        state.aiSettings?.let { settings ->
            selectedModelId = settings.model.id
            temperature = settings.temperature
            maxTokens = settings.maxTokens
        }
    }

    LaunchedEffect(state.secureValues[OPENAI_API_KEY]) {
        state.secureValues[OPENAI_API_KEY]?.let {
            openAIKey = it
        }
    }

    LaunchedEffect(state.secureValues[GEMINI_API_KEY]) {
        state.secureValues[GEMINI_API_KEY]?.let {
            geminiKey = it
        }
    }

    Column(
        modifier = Modifier
            .fillMaxSize()
            .verticalScroll(rememberScrollState())
            .padding(20.dp),
        verticalArrangement = Arrangement.spacedBy(16.dp)
    ) {

        Row(
            modifier = Modifier.fillMaxWidth(),
            verticalAlignment = Alignment.CenterVertically
        ) {
            IconButton(
                onClick = onBack
            ) {
                Icon(
                    imageVector = Icons.AutoMirrored.Default.ArrowBack,
                    contentDescription = "Back",
                    tint = colors.textPrimary
                )
            }

            Text(
                text = "Settings",
                color = colors.textPrimary
            )
        }

        HorizontalDivider(
            color = colors.divider
        )

        Text(
            text = "AI",
            color = colors.primary
        )

        Column(
            verticalArrangement = Arrangement.spacedBy(8.dp)
        ) {
            Text(
                text = "AI Model",
                color = colors.textPrimary
            )

            OutlinedTextField(
                value = state.availableAIModels
                    .firstOrNull { it.id == selectedModelId }
                    ?.name
                    ?: "Select model",
                onValueChange = {},
                readOnly = true,
                modifier = Modifier.fillMaxWidth(),
                trailingIcon = {
                    Text(
                        text = "▼",
                        color = colors.textSecondary
                    )
                }
            )

            DropdownMenu(
                expanded = modelMenuExpanded,
                onDismissRequest = {
                    modelMenuExpanded = false
                }
            ) {
                state.availableAIModels.forEach { model ->
                    DropdownMenuItem(
                        text = {
                            Text(
                                text = model.name,
                                color = colors.textPrimary
                            )
                        },
                        onClick = {
                            selectedModelId = model.id
                            modelMenuExpanded = false
                        }
                    )
                }
            }

            Spacer(
                modifier = Modifier
                    .fillMaxWidth()
                    .height(1.dp)
            )

            Button(
                onClick = {
                    modelMenuExpanded = true
                },
                modifier = Modifier.fillMaxWidth()
            ) {
                Text("Select AI Model")
            }
        }

        Column {
            Text(
                text = "Temperature: ${
                    String.format("%.2f", temperature)
                }",
                color = colors.textPrimary
            )

            Slider(
                value = temperature,
                onValueChange = {
                    temperature = it
                },
                valueRange = 0f..2f
            )
        }

        Column {
            Text(
                text = "Max Tokens: $maxTokens",
                color = colors.textPrimary
            )

            Slider(
                value = maxTokens.toFloat(),
                onValueChange = {
                    maxTokens = it.roundToInt()
                },
                valueRange = 256f..32768f
            )
        }

        Button(
            onClick = {
                val selectedModel = state.availableAIModels
                    .firstOrNull { it.id == selectedModelId }

                if (selectedModel != null) {
                    val settings = AISettings(
                        provider = selectedModel.provider,
                        model = selectedModel,
                        temperature = temperature,
                        maxTokens = maxTokens
                    )

                    if (state.aiSettings == null) {
                        viewModel.onEvent(
                            SettingsEvent.SaveAISettings(settings)
                        )
                    } else {
                        viewModel.onEvent(
                            SettingsEvent.UpdateAISettings(settings)
                        )
                    }
                }
            },
            modifier = Modifier.fillMaxWidth(),
            enabled = selectedModelId != null && !state.isSaving
        ) {
            if (state.isSaving) {
                CircularProgressIndicator()
            } else {
                Text("Save AI Settings")
            }
        }

        HorizontalDivider(
            color = colors.divider
        )

        Text(
            text = "Security",
            color = colors.primary
        )

        Text(
            text = "OpenAI API Key",
            color = colors.textPrimary
        )

        OutlinedTextField(
            value = openAIKey,
            onValueChange = {
                openAIKey = it
            },
            modifier = Modifier.fillMaxWidth(),
            label = {
                Text("OpenAI API Key")
            },
            singleLine = true,
            visualTransformation = if (openAIKeyVisible) {
                VisualTransformation.None
            } else {
                PasswordVisualTransformation()
            },
            trailingIcon = {
                IconButton(
                    onClick = {
                        openAIKeyVisible = !openAIKeyVisible
                    }
                ) {
                    Icon(
                        imageVector = if (openAIKeyVisible) {
                            Icons.Default.VisibilityOff
                        } else {
                            Icons.Default.Visibility
                        },
                        contentDescription = if (openAIKeyVisible) {
                            "Hide API key"
                        } else {
                            "Show API key"
                        },
                        tint = colors.textSecondary
                    )
                }
            }
        )

        Row(
            modifier = Modifier.fillMaxWidth(),
            horizontalArrangement = Arrangement.spacedBy(12.dp)
        ) {
            Button(
                onClick = {
                    if (openAIKey.isNotBlank()) {
                        viewModel.onEvent(
                            SettingsEvent.SaveSecureValue(
                                key = OPENAI_API_KEY,
                                value = openAIKey
                            )
                        )
                    }
                },
                modifier = Modifier.weight(1f),
                enabled = openAIKey.isNotBlank() && !state.isSaving
            ) {
                Text("Save Key")
            }

            Button(
                onClick = {
                    openAIKey = ""

                    viewModel.onEvent(
                        SettingsEvent.DeleteSecureValue(
                            OPENAI_API_KEY
                        )
                    )
                },
                modifier = Modifier.weight(1f)
            ) {
                Text("Delete Key")
            }
        }

        if (state.secureValuePresence[OPENAI_API_KEY] == true) {
            Text(
                text = "OpenAI API key is stored.",
                color = colors.success
            )
        }

        Spacer(
            modifier = Modifier.height(8.dp)
        )

        Text(
            text = "Gemini API Key",
            color = colors.textPrimary
        )

        OutlinedTextField(
            value = geminiKey,
            onValueChange = {
                geminiKey = it
            },
            modifier = Modifier.fillMaxWidth(),
            label = {
                Text("Gemini API Key")
            },
            singleLine = true,
            visualTransformation = if (geminiKeyVisible) {
                VisualTransformation.None
            } else {
                PasswordVisualTransformation()
            },
            trailingIcon = {
                IconButton(
                    onClick = {
                        geminiKeyVisible = !geminiKeyVisible
                    }
                ) {
                    Icon(
                        imageVector = if (geminiKeyVisible) {
                            Icons.Default.VisibilityOff
                        } else {
                            Icons.Default.Visibility
                        },
                        contentDescription = if (geminiKeyVisible) {
                            "Hide API key"
                        } else {
                            "Show API key"
                        },
                        tint = colors.textSecondary
                    )
                }
            }
        )

        Row(
            modifier = Modifier.fillMaxWidth(),
            horizontalArrangement = Arrangement.spacedBy(12.dp)
        ) {
            Button(
                onClick = {
                    if (geminiKey.isNotBlank()) {
                        viewModel.onEvent(
                            SettingsEvent.SaveSecureValue(
                                key = GEMINI_API_KEY,
                                value = geminiKey
                            )
                        )
                    }
                },
                modifier = Modifier.weight(1f),
                enabled = geminiKey.isNotBlank() && !state.isSaving
            ) {
                Text("Save Key")
            }

            Button(
                onClick = {
                    geminiKey = ""

                    viewModel.onEvent(
                        SettingsEvent.DeleteSecureValue(
                            GEMINI_API_KEY
                        )
                    )
                },
                modifier = Modifier.weight(1f)
            ) {
                Text("Delete Key")
            }
        }

        if (state.secureValuePresence[GEMINI_API_KEY] == true) {
            Text(
                text = "Gemini API key is stored.",
                color = colors.success
            )
        }

        HorizontalDivider(
            color = colors.divider
        )

        Text(
            text = "Application",
            color = colors.primary
        )

        Text(
            text = "Theme",
            color = colors.textPrimary
        )

        Text(
            text = "Theme has its own settings screen.",
            color = colors.textSecondary
        )

        Text(
            text = "Language and timezone are managed from Profile.",
            color = colors.textSecondary
        )

        state.error?.let { error ->
            Text(
                text = error,
                color = colors.error
            )
        }
    }
}