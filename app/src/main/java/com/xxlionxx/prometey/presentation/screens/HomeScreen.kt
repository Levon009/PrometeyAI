package com.xxlionxx.prometey.presentation.screens

import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.imePadding
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.layout.widthIn
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.lazy.rememberLazyListState
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Add
import androidx.compose.material.icons.filled.Info
import androidx.compose.material.icons.filled.Lock
import androidx.compose.material.icons.filled.Menu
import androidx.compose.material.icons.filled.Palette
import androidx.compose.material.icons.filled.Person
import androidx.compose.material.icons.filled.Send
import androidx.compose.material.icons.filled.Settings
import androidx.compose.material3.Divider
import androidx.compose.material3.DrawerValue
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.ModalDrawerSheet
import androidx.compose.material3.ModalNavigationDrawer
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBar
import androidx.compose.material3.rememberDrawerState
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.runtime.setValue
import androidx.compose.runtime.rememberCoroutineScope
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.input.ImeAction
import androidx.compose.foundation.text.KeyboardActions
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.ui.unit.dp
import androidx.lifecycle.compose.collectAsStateWithLifecycle
import androidx.navigation.NavHostController
import com.xxlionxx.prometey.data.user.CurrentUserManager
import com.xxlionxx.prometey.domain.model.Conversation
import com.xxlionxx.prometey.domain.model.ConversationStatus
import com.xxlionxx.prometey.domain.model.Message
import com.xxlionxx.prometey.domain.model.MessageRole
import com.xxlionxx.prometey.navigation.Routes
import com.xxlionxx.prometey.presentation.ChatViewModel
import com.xxlionxx.prometey.presentation.events.ChatEvent
import com.xxlionxx.prometey.ui.theme.LocalAppColors
import kotlinx.coroutines.launch
import org.koin.androidx.compose.koinViewModel
import org.koin.compose.koinInject
import java.util.UUID

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun HomeScreen(
    navController: NavHostController,
    modifier: Modifier = Modifier,
    viewModel: ChatViewModel = koinViewModel(),
    currentUserManager: CurrentUserManager = koinInject()
) {
    val colors = LocalAppColors.current
    val state by viewModel.state.collectAsStateWithLifecycle()

    val drawerState = rememberDrawerState(
        initialValue = DrawerValue.Closed
    )

    val scope = rememberCoroutineScope()

    var messageText by rememberSaveable {
        mutableStateOf("")
    }

    var initialConversationCreated by rememberSaveable {
        mutableStateOf(false)
    }

    /*
     * Load conversations for the current user.
     */
    LaunchedEffect(Unit) {
        val userId = currentUserManager.getCurrentUserId()

        viewModel.onEvent(
            ChatEvent.LoadConversations(userId)
        )
    }

    /*
     * If the user has no conversations yet,
     * automatically create the first one.
     *
     * This gives the user a real chat immediately
     * instead of an empty home screen.
     */
    LaunchedEffect(state.conversations) {
        if (
            state.conversations.isEmpty() &&
            !initialConversationCreated
        ) {
            initialConversationCreated = true

            val userId =
                currentUserManager.getCurrentUserId()

            val now =
                System.currentTimeMillis()

            val conversation =
                Conversation(
                    id = UUID.randomUUID().toString(),
                    userId = userId,
                    title = "New Chat",
                    status = ConversationStatus.ACTIVE,
                    createdAt = now,
                    updatedAt = now
                )

            viewModel.onEvent(
                ChatEvent.SaveConversation(
                    conversation
                )
            )
        }
    }

    /*
     * Automatically scroll to the newest message.
     */
    val listState = rememberLazyListState()

    LaunchedEffect(state.messages.size) {
        if (state.messages.isNotEmpty()) {
            listState.animateScrollToItem(
                state.messages.lastIndex
            )
        }
    }

    /*
     * Send the current text.
     */
    fun sendMessage() {
        val text = messageText.trim()

        if (
            text.isEmpty() ||
            state.selectedConversation == null ||
            state.isSending
        ) {
            return
        }

        messageText = ""

        viewModel.onEvent(
            ChatEvent.SendMessage(text)
        )
    }

    ModalNavigationDrawer(
        drawerState = drawerState,
        drawerContent = {
            ModalDrawerSheet(
                drawerContainerColor = colors.surface
            ) {
                HomeDrawer(
                    conversations = state.conversations,
                    selectedConversationId =
                        state.selectedConversation?.id,
                    colors = colors,
                    onNewChat = {
                        scope.launch {
                            drawerState.close()

                            val userId =
                                currentUserManager
                                    .getCurrentUserId()

                            val now =
                                System.currentTimeMillis()

                            val conversation =
                                Conversation(
                                    id =
                                        UUID.randomUUID()
                                            .toString(),
                                    userId = userId,
                                    title = "New Chat",
                                    status =
                                        ConversationStatus.ACTIVE,
                                    createdAt = now,
                                    updatedAt = now
                                )

                            viewModel.onEvent(
                                ChatEvent.SaveConversation(
                                    conversation
                                )
                            )

                            messageText = ""
                        }
                    },
                    onConversationClick = { conversation ->
                        scope.launch {
                            drawerState.close()
                        }

                        messageText = ""

                        viewModel.onEvent(
                            ChatEvent.LoadConversation(
                                conversation.id
                            )
                        )
                    },
                    onProfileClick = {
                        scope.launch {
                            drawerState.close()
                        }

                        navController.navigate(
                            Routes.Profile
                        )
                    },
                    onSettingsClick = {
                        scope.launch {
                            drawerState.close()
                        }

                        navController.navigate(
                            Routes.Settings
                        )
                    },
                    onThemeClick = {
                        scope.launch {
                            drawerState.close()
                        }

                        navController.navigate(
                            Routes.Theme
                        )
                    },
                    onPrivacyClick = {
                        scope.launch {
                            drawerState.close()
                        }

                        navController.navigate(
                            Routes.PrivacyPolicy
                        )
                    },
                    onAboutClick = {
                        scope.launch {
                            drawerState.close()
                        }

                        navController.navigate(
                            Routes.About
                        )
                    }
                )
            }
        }
    ) {
        Scaffold(
            modifier = modifier.fillMaxSize(),
            containerColor = colors.background,
            topBar = {
                TopAppBar(
                    title = {
                        Text(
                            text =
                                state.selectedConversation
                                    ?.title
                                    ?: "PROMETEY",
                            fontWeight =
                                FontWeight.SemiBold,
                            color = colors.textPrimary
                        )
                    },
                    navigationIcon = {
                        IconButton(
                            onClick = {
                                scope.launch {
                                    drawerState.open()
                                }
                            }
                        ) {
                            Icon(
                                imageVector =
                                    Icons.Default.Menu,
                                contentDescription =
                                    "Open menu",
                                tint = colors.textPrimary
                            )
                        }
                    },
                    actions = {
                        IconButton(
                            onClick = {
                                scope.launch {
                                    val userId =
                                        currentUserManager
                                            .getCurrentUserId()

                                    val now =
                                        System.currentTimeMillis()

                                    val conversation =
                                        Conversation(
                                            id =
                                                UUID.randomUUID()
                                                    .toString(),
                                            userId = userId,
                                            title = "New Chat",
                                            status =
                                                ConversationStatus.ACTIVE,
                                            createdAt = now,
                                            updatedAt = now
                                        )

                                    messageText = ""

                                    viewModel.onEvent(
                                        ChatEvent.SaveConversation(
                                            conversation
                                        )
                                    )
                                }
                            }
                        ) {
                            Icon(
                                imageVector =
                                    Icons.Default.Add,
                                contentDescription =
                                    "New chat",
                                tint = colors.primary
                            )
                        }
                    }
                )
            }
        ) { innerPadding ->

            Column(
                modifier = Modifier
                    .fillMaxSize()
                    .padding(innerPadding)
                    .imePadding()
            ) {

                /*
                 * MESSAGE AREA
                 */
                Box(
                    modifier = Modifier
                        .weight(1f)
                        .fillMaxWidth()
                ) {

                    if (
                        state.selectedConversation == null
                    ) {
                        EmptyChatContent(
                            colors = colors
                        )
                    } else if (
                        state.messages.isEmpty()
                    ) {
                        EmptyConversationContent(
                            colors = colors
                        )
                    } else {

                        LazyColumn(
                            modifier =
                                Modifier.fillMaxSize(),
                            state = listState,
                            verticalArrangement =
                                Arrangement.spacedBy(
                                    12.dp
                                ),
                            contentPadding =
                                PaddingValues(
                                    horizontal = 16.dp,
                                    vertical = 16.dp
                                )
                        ) {
                            items(
                                items = state.messages,
                                key = { it.id }
                            ) { message ->

                                ChatMessageBubble(
                                    message = message,
                                    colors = colors
                                )
                            }

                            if (state.isSending) {
                                item {
                                    TypingIndicator(
                                        colors = colors
                                    )
                                }
                            }
                        }
                    }
                }

                /*
                 * CHAT COMPOSER
                 */
                ChatComposer(
                    text = messageText,
                    onTextChange = {
                        messageText = it
                    },
                    onSend = {
                        sendMessage()
                    },
                    enabled =
                        state.selectedConversation != null &&
                                !state.isSending,
                    colors = colors
                )
            }
        }
    }
}

@Composable
private fun ChatMessageBubble(
    message: Message,
    colors: com.xxlionxx.prometey.ui.theme.AppColors
) {
    val isUser =
        message.role == MessageRole.USER

    Row(
        modifier = Modifier.fillMaxWidth(),
        horizontalArrangement =
            if (isUser) {
                Arrangement.End
            } else {
                Arrangement.Start
            }
    ) {

        Box(
            modifier = Modifier
                .widthIn(max = 340.dp)
                .clip(
                    RoundedCornerShape(18.dp)
                )
                .background(
                    if (isUser) {
                        colors.primary
                    } else {
                        colors.surface
                    }
                )
                .padding(
                    horizontal = 16.dp,
                    vertical = 12.dp
                )
        ) {
            Text(
                text = message.content,
                style =
                    MaterialTheme.typography.bodyLarge,
                color =
                    if (isUser) {
                        colors.background
                    } else {
                        colors.textPrimary
                    }
            )
        }
    }
}

@Composable
private fun ChatComposer(
    text: String,
    onTextChange: (String) -> Unit,
    onSend: () -> Unit,
    enabled: Boolean,
    colors: com.xxlionxx.prometey.ui.theme.AppColors
) {
    Row(
        modifier = Modifier
            .fillMaxWidth()
            .padding(
                horizontal = 12.dp,
                vertical = 8.dp
            ),
        verticalAlignment =
            Alignment.Bottom
    ) {

        OutlinedTextField(
            value = text,
            onValueChange = onTextChange,
            modifier = Modifier.weight(1f),
            enabled = enabled,
            placeholder = {
                Text(
                    text = "Message PROMETEY...",
                    color = colors.textMuted
                )
            },
            maxLines = 5,
            shape = RoundedCornerShape(24.dp),
            keyboardOptions =
                KeyboardOptions(
                    imeAction = ImeAction.Send
                ),
            keyboardActions =
                KeyboardActions(
                    onSend = {
                        if (enabled) {
                            onSend()
                        }
                    }
                )
        )

        Spacer(
            modifier = Modifier.width(8.dp)
        )

        IconButton(
            onClick = onSend,
            enabled =
                enabled &&
                        text.isNotBlank(),
            modifier = Modifier
                .size(52.dp)
                .clip(CircleShape)
                .background(
                    if (
                        enabled &&
                        text.isNotBlank()
                    ) {
                        colors.primary
                    } else {
                        colors.surfaceVariant
                    }
                )
        ) {
            Icon(
                imageVector =
                    Icons.Default.Send,
                contentDescription =
                    "Send message",
                tint =
                    if (
                        enabled &&
                        text.isNotBlank()
                    ) {
                        colors.background
                    } else {
                        colors.textMuted
                    }
            )
        }
    }
}

@Composable
private fun TypingIndicator(
    colors: com.xxlionxx.prometey.ui.theme.AppColors
) {
    Row(
        modifier = Modifier.fillMaxWidth(),
        horizontalArrangement =
            Arrangement.Start
    ) {
        Box(
            modifier = Modifier
                .clip(
                    RoundedCornerShape(18.dp)
                )
                .background(colors.surface)
                .padding(
                    horizontal = 16.dp,
                    vertical = 12.dp
                )
        ) {
            Text(
                text = "PROMETEY is thinking...",
                style =
                    MaterialTheme.typography.bodyMedium,
                color = colors.textSecondary
            )
        }
    }
}

@Composable
private fun EmptyChatContent(
    colors: com.xxlionxx.prometey.ui.theme.AppColors
) {
    Box(
        modifier = Modifier.fillMaxSize(),
        contentAlignment = Alignment.Center
    ) {
        Column(
            horizontalAlignment =
                Alignment.CenterHorizontally
        ) {
            Text(
                text = "PROMETEY",
                style =
                    MaterialTheme.typography.headlineMedium,
                fontWeight = FontWeight.Bold,
                color = colors.primary
            )

            Spacer(
                modifier = Modifier.height(8.dp)
            )

            Text(
                text = "Your Personal AI",
                style =
                    MaterialTheme.typography.bodyLarge,
                color = colors.textSecondary
            )

            Spacer(
                modifier = Modifier.height(6.dp)
            )

            Text(
                text = "Start a new conversation.",
                style =
                    MaterialTheme.typography.bodyMedium,
                color = colors.textMuted
            )
        }
    }
}

@Composable
private fun EmptyConversationContent(
    colors: com.xxlionxx.prometey.ui.theme.AppColors
) {
    Box(
        modifier = Modifier.fillMaxSize(),
        contentAlignment = Alignment.Center
    ) {
        Column(
            horizontalAlignment =
                Alignment.CenterHorizontally
        ) {
            Text(
                text = "PROMETEY",
                style =
                    MaterialTheme.typography.headlineMedium,
                fontWeight = FontWeight.Bold,
                color = colors.primary
            )

            Spacer(
                modifier = Modifier.height(8.dp)
            )

            Text(
                text = "How can I help you?",
                style =
                    MaterialTheme.typography.bodyLarge,
                color = colors.textSecondary
            )

            Spacer(
                modifier = Modifier.height(6.dp)
            )

            Text(
                text = "Type a message below to begin.",
                style =
                    MaterialTheme.typography.bodyMedium,
                color = colors.textMuted
            )
        }
    }
}

@Composable
private fun HomeDrawer(
    conversations: List<Conversation>,
    selectedConversationId: String?,
    colors: com.xxlionxx.prometey.ui.theme.AppColors,
    onNewChat: () -> Unit,
    onConversationClick: (Conversation) -> Unit,
    onProfileClick: () -> Unit,
    onSettingsClick: () -> Unit,
    onThemeClick: () -> Unit,
    onPrivacyClick: () -> Unit,
    onAboutClick: () -> Unit
) {
    Column(
        modifier = Modifier.fillMaxSize()
    ) {

        Column(
            modifier = Modifier
                .fillMaxWidth()
                .padding(20.dp)
        ) {
            Box(
                modifier = Modifier
                    .size(52.dp)
                    .clip(CircleShape)
                    .background(colors.primary),
                contentAlignment =
                    Alignment.Center
            ) {
                Text(
                    text = "P",
                    color = colors.background,
                    style =
                        MaterialTheme.typography.headlineSmall,
                    fontWeight = FontWeight.Bold
                )
            }

            Spacer(
                modifier = Modifier.height(12.dp)
            )

            Text(
                text = "PROMETEY",
                style =
                    MaterialTheme.typography.titleLarge,
                fontWeight = FontWeight.Bold,
                color = colors.textPrimary
            )

            Text(
                text = "Your Personal AI",
                style =
                    MaterialTheme.typography.bodyMedium,
                color = colors.textSecondary
            )
        }

        DrawerAction(
            icon = Icons.Default.Add,
            title = "New Chat",
            colors = colors,
            onClick = onNewChat
        )

        Spacer(
            modifier = Modifier.height(8.dp)
        )

        Text(
            text = "History",
            modifier = Modifier.padding(
                horizontal = 20.dp,
                vertical = 8.dp
            ),
            style =
                MaterialTheme.typography.labelLarge,
            fontWeight =
                FontWeight.SemiBold,
            color = colors.textMuted
        )

        if (conversations.isEmpty()) {

            Text(
                text = "No conversations yet.",
                modifier = Modifier.padding(
                    horizontal = 20.dp,
                    vertical = 8.dp
                ),
                style =
                    MaterialTheme.typography.bodyMedium,
                color = colors.textSecondary
            )

        } else {

            LazyColumn(
                modifier = Modifier.weight(1f)
            ) {
                items(
                    items = conversations,
                    key = { it.id }
                ) { conversation ->

                    val isSelected =
                        conversation.id ==
                                selectedConversationId

                    Row(
                        modifier = Modifier
                            .fillMaxWidth()
                            .clickable {
                                onConversationClick(
                                    conversation
                                )
                            }
                            .background(
                                if (isSelected) {
                                    colors.surfaceVariant
                                } else {
                                    colors.surface
                                }
                            )
                            .padding(
                                horizontal = 20.dp,
                                vertical = 12.dp
                            ),
                        verticalAlignment =
                            Alignment.CenterVertically
                    ) {

                        Text(
                            text =
                                conversation.title
                                    ?.takeIf {
                                        it.isNotBlank()
                                    }
                                    ?: "New Chat",
                            modifier =
                                Modifier.weight(1f),
                            style =
                                MaterialTheme.typography.bodyLarge,
                            fontWeight =
                                if (isSelected) {
                                    FontWeight.SemiBold
                                } else {
                                    FontWeight.Normal
                                },
                            color =
                                colors.textPrimary,
                            maxLines = 1
                        )
                    }
                }
            }
        }

        Divider(
            color = colors.divider
        )

        DrawerAction(
            icon = Icons.Default.Person,
            title = "Profile",
            colors = colors,
            onClick = onProfileClick
        )

        DrawerAction(
            icon = Icons.Default.Settings,
            title = "Settings",
            colors = colors,
            onClick = onSettingsClick
        )

        DrawerAction(
            icon = Icons.Default.Palette,
            title = "Theme",
            colors = colors,
            onClick = onThemeClick
        )

        DrawerAction(
            icon = Icons.Default.Lock,
            title = "Privacy Policy",
            colors = colors,
            onClick = onPrivacyClick
        )

        DrawerAction(
            icon = Icons.Default.Info,
            title = "About",
            colors = colors,
            onClick = onAboutClick
        )

        Spacer(
            modifier = Modifier.height(12.dp)
        )
    }
}

@Composable
private fun DrawerAction(
    icon: androidx.compose.ui.graphics.vector.ImageVector,
    title: String,
    colors: com.xxlionxx.prometey.ui.theme.AppColors,
    onClick: () -> Unit
) {
    Row(
        modifier = Modifier
            .fillMaxWidth()
            .clickable(onClick = onClick)
            .padding(
                horizontal = 20.dp,
                vertical = 13.dp
            ),
        verticalAlignment =
            Alignment.CenterVertically
    ) {

        Icon(
            imageVector = icon,
            contentDescription = title,
            tint = colors.textPrimary,
            modifier = Modifier.size(22.dp)
        )

        Spacer(
            modifier = Modifier.width(16.dp)
        )

        Text(
            text = title,
            style =
                MaterialTheme.typography.bodyLarge,
            color = colors.textPrimary
        )
    }
}