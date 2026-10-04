package com.xxlionxx.prometey.presentation.screens

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.verticalScroll
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp

@Composable
fun AboutScreen(
    modifier: Modifier = Modifier
) {
    Column(
        modifier = modifier
            .fillMaxSize()
            .verticalScroll(rememberScrollState())
            .padding(24.dp),
        verticalArrangement = Arrangement.spacedBy(14.dp)
    ) {

        Text(
            text = "PROMETEY",
            style = MaterialTheme.typography.headlineLarge,
            fontWeight = FontWeight.Bold
        )

        Text(
            text = "Your Personal AI",
            style = MaterialTheme.typography.titleLarge,
            fontWeight = FontWeight.SemiBold
        )

        Text(
            text = "Prometey is designed to become more than a chatbot. "
                    + "It is a personal artificial intelligence assistant designed "
                    + "to understand your history, remember important information "
                    + "about you, work with your personal context, and provide "
                    + "assistance that becomes more relevant over time.",
            style = MaterialTheme.typography.bodyLarge
        )

        Spacer(
            modifier = Modifier.height(8.dp)
        )

        Text(
            text = "A Personal Memory",
            style = MaterialTheme.typography.titleLarge,
            fontWeight = FontWeight.Bold
        )

        Text(
            text = "One of the central ideas behind Prometey is long-term personal memory. "
                    + "Instead of treating every conversation as completely separate, "
                    + "Prometey is designed to preserve useful information about you "
                    + "and your life so that it can be used as personal context in future conversations.",
            style = MaterialTheme.typography.bodyLarge
        )

        Text(
            text = "This memory can include things such as your preferences, important people, "
                    + "goals, plans, conversations, personal notes, important events, "
                    + "images, and other information that you choose to preserve.",
            style = MaterialTheme.typography.bodyLarge
        )

        Text(
            text = "The goal is long-term continuity. With appropriate storage and "
                    + "user-controlled data retention, your personal history can remain "
                    + "available for years rather than being limited to a single conversation. "
                    + "Prometey is designed with the idea that information you intentionally "
                    + "save today could still be useful many years from now.",
            style = MaterialTheme.typography.bodyLarge
        )

        Text(
            text = "Personal Context",
            style = MaterialTheme.typography.titleLarge,
            fontWeight = FontWeight.Bold
        )

        Text(
            text = "Prometey can use your personal context to make its assistance more meaningful. "
                    + "For example, it can take into account information you previously provided, "
                    + "your preferences, goals, ongoing situations, and previous conversations "
                    + "when generating a response.",
            style = MaterialTheme.typography.bodyLarge
        )

        Text(
            text = "The intention is to create an assistant that knows the context of your journey "
                    + "instead of behaving like a completely new assistant every time you open it.",
            style = MaterialTheme.typography.bodyLarge
        )

        Text(
            text = "Health and Well-Being",
            style = MaterialTheme.typography.titleLarge,
            fontWeight = FontWeight.Bold
        )

        Text(
            text = "Prometey is designed to help you organize and remember health-related "
                    + "information that you choose to store, such as appointments, personal notes, "
                    + "medications, important dates, questions for your doctor, or other health "
                    + "information that you want to keep available.",
            style = MaterialTheme.typography.bodyLarge
        )

        Text(
            text = "For example, you may be able to tell Prometey to remember an important "
                    + "health-related event and later ask it to help you recall what happened "
                    + "or prepare questions for a medical appointment.",
            style = MaterialTheme.typography.bodyLarge
        )

        Text(
            text = "Prometey is not intended to replace doctors, emergency services, or "
                    + "professional medical care. Health-related information should be treated "
                    + "as assistance and organization, not as a medical diagnosis.",
            style = MaterialTheme.typography.bodyLarge
        )

        Text(
            text = "Emotional and Psychological Support",
            style = MaterialTheme.typography.titleLarge,
            fontWeight = FontWeight.Bold
        )

        Text(
            text = "Life can become difficult because of health problems, relationships, "
                    + "financial pressure, loneliness, loss, work, stress, or other personal situations.",
            style = MaterialTheme.typography.bodyLarge
        )

        Text(
            text = "Prometey is designed to provide a supportive conversational space where "
                    + "you can talk about what you are experiencing, organize your thoughts, "
                    + "explore possible ways of approaching a difficult situation, and receive "
                    + "calm, contextual assistance based on information you have chosen to share.",
            style = MaterialTheme.typography.bodyLarge
        )

        Text(
            text = "It is not a replacement for a psychologist, psychiatrist, doctor, "
                    + "or emergency service. When professional or emergency help is needed, "
                    + "Prometey should support you in seeking appropriate human assistance.",
            style = MaterialTheme.typography.bodyLarge
        )

        Text(
            text = "Personal Forecasting",
            style = MaterialTheme.typography.titleLarge,
            fontWeight = FontWeight.Bold
        )

        Text(
            text = "Prometey is also designed to analyze personal context and provide forecasts "
                    + "and scenarios based on the information available to it.",
            style = MaterialTheme.typography.bodyLarge
        )

        Text(
            text = "Depending on the information and tools available, this can include personal "
                    + "planning, possible future scenarios, risks, recommendations, trends, "
                    + "and uncertainty around different outcomes.",
            style = MaterialTheme.typography.bodyLarge
        )

        Text(
            text = "A forecast is not a guarantee of what will happen. Its purpose is to help "
                    + "you think about possible futures and make better-informed personal plans.",
            style = MaterialTheme.typography.bodyLarge
        )

        Text(
            text = "Reminders and Personal Tasks",
            style = MaterialTheme.typography.titleLarge,
            fontWeight = FontWeight.Bold
        )

        Text(
            text = "Prometey is designed to become capable of remembering things you ask it "
                    + "to remember and reminding you about them at the appropriate time.",
            style = MaterialTheme.typography.bodyLarge
        )

        Text(
            text = "For example, you could tell Prometey: "
                    + "\"Remind me at 5 PM to call my doctor.\" "
                    + "A future reminder system can then create a notification on your phone "
                    + "at the requested time.",
            style = MaterialTheme.typography.bodyLarge
        )

        Text(
            text = "Reminder and notification functionality is planned as part of the "
                    + "application's future capabilities.",
            style = MaterialTheme.typography.bodyLarge
        )

        Text(
            text = "Privacy and Security",
            style = MaterialTheme.typography.titleLarge,
            fontWeight = FontWeight.Bold
        )

        Text(
            text = "Privacy is a fundamental part of Prometey's design. Personal information "
                    + "should not be treated as ordinary application data.",
            style = MaterialTheme.typography.bodyLarge
        )

        Text(
            text = "Prometey is designed around local-first personal data storage, controlled "
                    + "access to sensitive information, and security mechanisms intended to "
                    + "protect information stored on the device.",
            style = MaterialTheme.typography.bodyLarge
        )

        Text(
            text = "Sensitive information can be protected using Android security technologies "
                    + "such as the Android Keystore and encrypted storage. The application is "
                    + "also designed so that sensitive information can be kept under the user's "
                    + "control rather than automatically being exposed to external services.",
            style = MaterialTheme.typography.bodyLarge
        )

        Text(
            text = "When an external AI or network service is used, Prometey should only send "
                    + "information that is necessary for that operation and permitted by the "
                    + "application's privacy and data-control rules. The long-term goal is to "
                    + "minimize unnecessary data leaving the device.",
            style = MaterialTheme.typography.bodyLarge
        )

        Text(
            text = "Your Information, Your Control",
            style = MaterialTheme.typography.titleLarge,
            fontWeight = FontWeight.Bold
        )

        Text(
            text = "Prometey is being designed around the principle that your personal information "
                    + "belongs under your control.",
            style = MaterialTheme.typography.bodyLarge
        )

        Text(
            text = "You should be able to decide what information is remembered, what information "
                    + "is removed, what sensitive information is protected, and which capabilities "
                    + "are allowed to access your personal context.",
            style = MaterialTheme.typography.bodyLarge
        )

        Text(
            text = "The goal is not simply to build another AI chat application. "
                    + "The goal is to build a personal intelligence system that can grow with you, "
                    + "remember what matters to you, help you organize your life, and provide "
                    + "context-aware assistance while keeping privacy and user control at the center.",
            style = MaterialTheme.typography.bodyLarge
        )

        Spacer(
            modifier = Modifier.height(8.dp)
        )

        Text(
            text = "PROMETEY — Personal Intelligence",
            style = MaterialTheme.typography.titleMedium,
            fontWeight = FontWeight.SemiBold
        )

        Text(
            text = "Version 1.0",
            style = MaterialTheme.typography.bodyMedium
        )
    }
}