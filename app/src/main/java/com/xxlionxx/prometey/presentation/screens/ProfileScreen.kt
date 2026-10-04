package com.xxlionxx.prometey.presentation.screens

import android.content.Intent
import androidx.activity.compose.rememberLauncherForActivityResult
import androidx.activity.result.contract.ActivityResultContracts
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material3.Button
import androidx.compose.material3.CircularProgressIndicator
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.lifecycle.compose.collectAsStateWithLifecycle
import coil.compose.AsyncImage
import com.xxlionxx.prometey.data.user.CurrentUserManager
import com.xxlionxx.prometey.domain.model.User
import com.xxlionxx.prometey.domain.model.UserProfile
import com.xxlionxx.prometey.presentation.ProfileViewModel
import com.xxlionxx.prometey.presentation.events.ProfileEvent
import com.xxlionxx.prometey.ui.theme.LocalAppColors
import org.koin.androidx.compose.koinViewModel
import org.koin.compose.koinInject
import androidx.compose.ui.platform.LocalContext

@Composable
fun ProfileScreen(
    modifier: Modifier = Modifier,
    viewModel: ProfileViewModel = koinViewModel(),
    currentUserManager: CurrentUserManager = koinInject()
) {
    val colors = LocalAppColors.current
    val context = LocalContext.current

    var userId by remember {
        mutableStateOf<String?>(null)
    }

    var name by remember {
        mutableStateOf("")
    }

    var displayName by remember {
        mutableStateOf("")
    }

    var language by remember {
        mutableStateOf("")
    }

    var timezone by remember {
        mutableStateOf("")
    }

    var avatarUri by remember {
        mutableStateOf<String?>(null)
    }

    var initialized by remember {
        mutableStateOf(false)
    }

    val state by viewModel.state.collectAsStateWithLifecycle()

    val imagePickerLauncher =
        rememberLauncherForActivityResult(
            contract = ActivityResultContracts.OpenDocument()
        ) { uri ->
            uri ?: return@rememberLauncherForActivityResult

            try {
                context.contentResolver.takePersistableUriPermission(
                    uri,
                    Intent.FLAG_GRANT_READ_URI_PERMISSION
                )
            } catch (_: SecurityException) {
                // Some providers do not support persistable permissions.
            }

            avatarUri = uri.toString()
        }

    LaunchedEffect(Unit) {
        val currentUserId = currentUserManager.getCurrentUserId()

        userId = currentUserId

        viewModel.onEvent(
            ProfileEvent.LoadUser(currentUserId)
        )

        viewModel.onEvent(
            ProfileEvent.LoadProfile(currentUserId)
        )
    }

    LaunchedEffect(state.user, state.profile) {
        if (!initialized && (state.user != null || state.profile != null)) {
            name = state.user?.name.orEmpty()
            displayName = state.profile?.displayName.orEmpty()
            language = state.profile?.language ?: "English"
            timezone = state.profile?.timezone.orEmpty()
            avatarUri = state.profile?.avatarUri

            initialized = true
        }
    }

    Box(
        modifier = modifier
            .fillMaxSize()
            .background(colors.background)
    ) {
        if (state.isLoading && !initialized) {
            CircularProgressIndicator(
                modifier = Modifier.align(Alignment.Center),
                color = colors.primary
            )
        } else {
            Column(
                modifier = Modifier
                    .fillMaxSize()
                    .padding(
                        horizontal = 24.dp,
                        vertical = 28.dp
                    ),
                verticalArrangement = Arrangement.spacedBy(16.dp)
            ) {
                Column(
                    modifier = Modifier
                        .fillMaxSize()
                ) {
                    Text(
                        text = "Profile",
                        style = MaterialTheme.typography.headlineLarge,
                        fontWeight = FontWeight.Bold,
                        color = colors.textPrimary
                    )

                    Text(
                        text = "Personalize Prometey with your information.",
                        style = MaterialTheme.typography.bodyLarge,
                        color = colors.textSecondary
                    )

                    Spacer(
                        modifier = Modifier.height(20.dp)
                    )

                    Column(
                        modifier = Modifier.fillMaxWidth(),
                        horizontalAlignment = Alignment.CenterHorizontally
                    ) {
                        if (!avatarUri.isNullOrBlank()) {
                            AsyncImage(
                                model = avatarUri,
                                contentDescription = "Profile photo",
                                modifier = Modifier
                                    .size(120.dp)
                                    .clip(CircleShape)
                                    .border(
                                        width = 2.dp,
                                        color = colors.primary,
                                        shape = CircleShape
                                    ),
                                contentScale = ContentScale.Crop
                            )
                        } else {
                            Box(
                                modifier = Modifier
                                    .size(120.dp)
                                    .clip(CircleShape)
                                    .background(colors.surfaceVariant)
                                    .border(
                                        width = 2.dp,
                                        color = colors.primary,
                                        shape = CircleShape
                                    ),
                                contentAlignment = Alignment.Center
                            ) {
                                Text(
                                    text = "👤",
                                    style = MaterialTheme.typography.displaySmall
                                )
                            }
                        }

                        Spacer(
                            modifier = Modifier.height(12.dp)
                        )

                        Row(
                            horizontalArrangement = Arrangement.spacedBy(12.dp)
                        ) {
                            Text(
                                text = "Change photo",
                                color = colors.primary,
                                fontWeight = FontWeight.SemiBold,
                                modifier = Modifier.clickable(
                                    enabled = !state.isSaving
                                ) {
                                    imagePickerLauncher.launch(
                                        arrayOf("image/*")
                                    )
                                }
                            )

                            if (!avatarUri.isNullOrBlank()) {
                                Text(
                                    text = "Remove",
                                    color = colors.error,
                                    fontWeight = FontWeight.SemiBold,
                                    modifier = Modifier.clickable(
                                        enabled = !state.isSaving
                                    ) {
                                        avatarUri = null
                                    }
                                )
                            }
                        }
                    }

                    Spacer(
                        modifier = Modifier.height(12.dp)
                    )

                    ProfileTextField(
                        value = name,
                        onValueChange = {
                            name = it
                        },
                        label = "Name",
                        placeholder = "Enter your name",
                        enabled = !state.isSaving,
                        colors = colors
                    )

                    ProfileTextField(
                        value = displayName,
                        onValueChange = {
                            displayName = it
                        },
                        label = "Display name",
                        placeholder = "How Prometey should address you",
                        enabled = !state.isSaving,
                        colors = colors
                    )

                    ProfileTextField(
                        value = language,
                        onValueChange = {
                            language = it
                        },
                        label = "Language",
                        placeholder = "English",
                        enabled = !state.isSaving,
                        colors = colors
                    )

                    ProfileTextField(
                        value = timezone,
                        onValueChange = {
                            timezone = it
                        },
                        label = "Timezone",
                        placeholder = "Asia/Yerevan",
                        enabled = !state.isSaving,
                        colors = colors
                    )

                    if (!state.error.isNullOrBlank()) {
                        Text(
                            text = state.error.orEmpty(),
                            style = MaterialTheme.typography.bodyMedium,
                            color = colors.error
                        )
                    }

                    Spacer(
                        modifier = Modifier.height(8.dp)
                    )

                    Button(
                        modifier = Modifier
                            .fillMaxWidth()
                            .height(52.dp),
                        enabled = !state.isSaving &&
                                !userId.isNullOrBlank() &&
                                name.isNotBlank(),
                        onClick = {
                            val currentUserId =
                                userId ?: return@Button

                            val existingUser = state.user

                            val user = User(
                                id = currentUserId,
                                name = name.trim()
                            )

                            if (existingUser == null) {
                                viewModel.onEvent(
                                    ProfileEvent.SaveUser(user)
                                )
                            } else {
                                viewModel.onEvent(
                                    ProfileEvent.UpdateUser(user)
                                )
                            }

                            val profile = UserProfile(
                                userId = currentUserId,
                                displayName = displayName
                                    .trim()
                                    .ifBlank { null },
                                language = language.trim(),
                                timezone = timezone.trim(),
                                avatarUri = avatarUri
                            )

                            if (state.profile == null) {
                                viewModel.onEvent(
                                    ProfileEvent.SaveProfile(profile)
                                )
                            } else {
                                viewModel.onEvent(
                                    ProfileEvent.UpdateProfile(profile)
                                )
                            }
                        }
                    ) {
                        if (state.isSaving) {
                            CircularProgressIndicator(
                                modifier = Modifier.size(22.dp),
                                strokeWidth = 2.dp
                            )
                        } else {
                            Text(
                                text = "Save Profile",
                                fontWeight = FontWeight.SemiBold
                            )
                        }
                    }

                    Spacer(
                        modifier = Modifier.height(16.dp)
                    )
                }
            }
        }
    }
}

@Composable
private fun ProfileTextField(
    value: String,
    onValueChange: (String) -> Unit,
    label: String,
    placeholder: String,
    enabled: Boolean,
    colors: com.xxlionxx.prometey.ui.theme.AppColors
) {
    OutlinedTextField(
        modifier = Modifier.fillMaxWidth(),
        value = value,
        onValueChange = onValueChange,
        enabled = enabled,
        label = {
            Text(text = label)
        },
        placeholder = {
            Text(text = placeholder)
        },
        singleLine = true,
        shape = MaterialTheme.shapes.medium
    )
}