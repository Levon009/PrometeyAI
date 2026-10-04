package com.xxlionxx.prometey.presentation.screens

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.verticalScroll
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp

@Composable
fun PrivacyPolicyScreen(
    modifier: Modifier = Modifier
) {
    val backgroundColor = Color(0xFF0A0A0A)
    val primaryTextColor = Color(0xFFE8E8E8)
    val secondaryTextColor = Color(0xFFB8B8B8)
    val accentColor = Color(0xFF66FF66)

    Column(
        modifier = modifier
            .fillMaxSize()
            .background(backgroundColor)
            .verticalScroll(rememberScrollState())
            .padding(
                horizontal = 24.dp,
                vertical = 28.dp
            ),
        verticalArrangement = Arrangement.spacedBy(18.dp)
    ) {
        Text(
            text = "PROMETEY",
            style = MaterialTheme.typography.labelLarge,
            fontWeight = FontWeight.Bold,
            color = accentColor
        )

        Text(
            text = "Privacy Policy",
            style = MaterialTheme.typography.headlineLarge,
            fontWeight = FontWeight.Bold,
            color = primaryTextColor
        )

        Text(
            text = "Last updated: September 2026",
            style = MaterialTheme.typography.bodyMedium,
            color = secondaryTextColor
        )

        PolicySection(
            title = "1. Introduction",
            text = """
                Prometey is a personal AI assistant designed to provide conversational
                assistance, personalization, memory, voice interaction, image
                understanding, and other intelligent features.

                Privacy and user control are important principles of Prometey.
                This Privacy Policy explains what information Prometey may process,
                how that information may be used, where it may be stored, and what
                choices may be available to you.

                By using Prometey, you acknowledge that some features may require
                information to be processed locally on your device and that other
                features may require communication with external services.
            """.trimIndent(),
            primaryTextColor = primaryTextColor,
            secondaryTextColor = secondaryTextColor
        )

        PolicySection(
            title = "2. Information You Provide",
            text = """
                Depending on the features you use, you may voluntarily provide
                information such as:

                • Your name and profile information
                • Email address or other identity information
                • Personal preferences
                • Personal goals
                • Conversations and messages
                • Information you intentionally ask Prometey to remember
                • Images and other attachments
                • Voice input
                • Other information you voluntarily provide during interaction

                You should avoid providing highly sensitive information unless it is
                necessary for the feature you are using and you understand how that
                information may be processed.
            """.trimIndent(),
            primaryTextColor = primaryTextColor,
            secondaryTextColor = secondaryTextColor
        )

        PolicySection(
            title = "3. Personal Profile",
            text = """
                Prometey may allow you to create and maintain a personal profile.

                Profile information may include information such as your name,
                language, email address, personal description, and other information
                that you choose to provide.

                Profile information may be stored locally and may be used to
                personalize your interactions with Prometey.
            """.trimIndent(),
            primaryTextColor = primaryTextColor,
            secondaryTextColor = secondaryTextColor
        )

        PolicySection(
            title = "4. Personal Memory",
            text = """
                Prometey may provide a personal memory feature that allows selected
                information to be retained so that future interactions can be more
                relevant and personalized.

                Memory information may include facts, preferences, goals, interests,
                or other information that you intentionally provide or that the
                application determines is appropriate to retain according to its
                implemented memory functionality.

                Memory is intended to remain under your control. Where supported by
                the application, you may review, modify, or delete stored memories.
            """.trimIndent(),
            primaryTextColor = primaryTextColor,
            secondaryTextColor = secondaryTextColor
        )

        PolicySection(
            title = "5. Conversations and Messages",
            text = """
                Prometey may store conversations and messages on your device so that
                conversation history, personalization, and related features can work.

                When you send a message to an external AI service, information from
                that interaction may leave your device and be processed by the
                relevant service.

                The handling of information by an external AI provider is also subject
                to that provider's own privacy policy and terms.
            """.trimIndent(),
            primaryTextColor = primaryTextColor,
            secondaryTextColor = secondaryTextColor
        )

        PolicySection(
            title = "6. Images and Attachments",
            text = """
                If you choose to attach an image or another supported file, Prometey
                may access the selected content for the feature you requested.

                Some image-analysis or AI features may require an image to be
                transmitted to an external AI or network service.

                Prometey does not claim that an image always remains exclusively on
                your device when you explicitly use a network-based image-analysis
                feature.
            """.trimIndent(),
            primaryTextColor = primaryTextColor,
            secondaryTextColor = secondaryTextColor
        )

        PolicySection(
            title = "7. Voice Features",
            text = """
                Prometey may provide speech-to-text and text-to-speech functionality.

                When you use voice input, audio may be processed locally or by an
                external speech-recognition service depending on the implementation
                and configuration of the feature.

                Voice functionality may require microphone permission from Android.

                Voice input is used to provide the voice-related functionality that
                you request and is not intended to provide unrelated background
                microphone monitoring.
            """.trimIndent(),
            primaryTextColor = primaryTextColor,
            secondaryTextColor = secondaryTextColor
        )

        PolicySection(
            title = "8. External AI and Network Services",
            text = """
                Some Prometey features require communication with external services,
                including AI providers, speech services, network services, or other
                third-party infrastructure.

                When an external service is required, information necessary to
                perform the requested operation may leave your device and be sent
                to that service.

                Examples may include information from a conversation, an image that
                you ask Prometey to analyze, or other content required to complete
                the requested operation.

                Prometey does not represent that all information processed by an
                external service is stored exclusively on your device.
            """.trimIndent(),
            primaryTextColor = primaryTextColor,
            secondaryTextColor = secondaryTextColor
        )

        PolicySection(
            title = "9. Local Storage",
            text = """
                Prometey is designed to use local storage for information that can
                appropriately remain on your device.

                Depending on the implemented features, local application data may
                include:

                • Profile information
                • Preferences
                • Goals
                • Memories
                • Conversations
                • Messages
                • Attachments or attachment references
                • Application settings
                • AI-related settings
                • Other application data required for functionality

                Local storage does not mean that information can never leave the
                device. Network-based AI and other requested online features may
                require information to be transmitted externally.
            """.trimIndent(),
            primaryTextColor = primaryTextColor,
            secondaryTextColor = secondaryTextColor
        )

        PolicySection(
            title = "10. Security",
            text = """
                Prometey is designed with privacy and security in mind.

                The application may use Android security mechanisms and protected
                storage for sensitive information.

                Security measures may evolve as the application develops and new
                security improvements become available.

                No method of electronic storage, processing, or transmission can
                be guaranteed to be completely secure.
            """.trimIndent(),
            primaryTextColor = primaryTextColor,
            secondaryTextColor = secondaryTextColor
        )

        PolicySection(
            title = "11. Android Permissions",
            text = """
                Prometey may request Android permissions when they are necessary for
                a particular feature.

                Depending on the features enabled in a particular version, these
                permissions may include:

                • Internet access for network-based AI and online functionality
                • Microphone access for voice input
                • Photo or media access when required to select images or attachments

                Prometey is designed to request permissions only when the associated
                functionality requires them.

                You can manage application permissions through Android system
                settings.
            """.trimIndent(),
            primaryTextColor = primaryTextColor,
            secondaryTextColor = secondaryTextColor
        )

        PolicySection(
            title = "12. Data Deletion and User Control",
            text = """
                Prometey is designed to give you control over personal information
                stored by the application.

                Where supported by the application, you may delete or modify
                information such as conversations, messages, memories, profile
                information, preferences, goals, and application data.

                Deleting information from your device does not necessarily delete
                information that may already have been transmitted to an external
                service.

                Information already processed by an external service is subject to
                that service's applicable policies and retention practices.
            """.trimIndent(),
            primaryTextColor = primaryTextColor,
            secondaryTextColor = secondaryTextColor
        )

        PolicySection(
            title = "13. Backups and Device Transfers",
            text = """
                Android or other platform-level backup and device-transfer mechanisms
                may apply depending on your device, operating system, and application
                configuration.

                Information included in a platform backup may be subject to the
                platform provider's backup and privacy policies.

                Prometey does not guarantee that every piece of locally stored
                information is excluded from platform-level backup unless the
                application explicitly implements such behavior.
            """.trimIndent(),
            primaryTextColor = primaryTextColor,
            secondaryTextColor = secondaryTextColor
        )

        PolicySection(
            title = "14. Subscriptions and Payments",
            text = """
                Prometey may offer subscriptions, trials, or other paid features.

                Depending on where you obtain Prometey, payments may be processed
                through the applicable application store or payment platform.

                Prometey is designed not to require the application itself to receive
                or store your complete payment-card credentials when payment is
                processed by an application store.

                Payment processing, billing information, refunds, transaction
                records, and payment security are also subject to the policies and
                terms of the applicable payment provider or application store.
            """.trimIndent(),
            primaryTextColor = primaryTextColor,
            secondaryTextColor = secondaryTextColor
        )

        PolicySection(
            title = "15. Third-Party Services",
            text = """
                Prometey may use third-party services to provide specific
                functionality.

                These services may include AI providers, speech services, hosting
                infrastructure, application stores, payment services, or other
                technical services required by the application.

                Third-party services may process information according to their own
                privacy policies and terms.

                Prometey will not describe a third-party service as local-only when
                the requested feature requires external processing.
            """.trimIndent(),
            primaryTextColor = primaryTextColor,
            secondaryTextColor = secondaryTextColor
        )

        PolicySection(
            title = "16. Analytics and Diagnostics",
            text = """
                Future versions of Prometey may use analytics, crash reporting, or
                diagnostic services to improve application reliability and performance.

                If such services are introduced, the applicable implementation and
                privacy disclosures will be reviewed and updated accordingly.

                Prometey does not intentionally describe a diagnostic service as
                local-only when information is actually transmitted to a third party.
            """.trimIndent(),
            primaryTextColor = primaryTextColor,
            secondaryTextColor = secondaryTextColor
        )

        PolicySection(
            title = "17. Children's Privacy",
            text = """
                Prometey is not designed to knowingly collect personal information
                from children in violation of applicable law.

                If you believe that a child has provided personal information through
                Prometey in a manner that should not have occurred, please contact
                the developer so that the situation can be reviewed and appropriate
                action can be taken.
            """.trimIndent(),
            primaryTextColor = primaryTextColor,
            secondaryTextColor = secondaryTextColor
        )

        PolicySection(
            title = "18. External Links",
            text = """
                Prometey may provide links to external websites or services.

                When you leave Prometey and interact with an external website or
                service, that service's own privacy policy and terms apply.

                Prometey is not responsible for the privacy practices of external
                websites that it does not operate.
            """.trimIndent(),
            primaryTextColor = primaryTextColor,
            secondaryTextColor = secondaryTextColor
        )

        PolicySection(
            title = "19. Changes to This Privacy Policy",
            text = """
                This Privacy Policy may be updated when Prometey's functionality,
                data practices, security measures, third-party services, or legal
                requirements change.

                When appropriate, the updated policy will be made available through
                the application or another appropriate channel.

                The date shown at the beginning of this policy indicates when the
                current version was last updated.
            """.trimIndent(),
            primaryTextColor = primaryTextColor,
            secondaryTextColor = secondaryTextColor
        )

        PolicySection(
            title = "20. Contact",
            text = """
                If you have questions, concerns, or requests regarding privacy or
                personal information processed by Prometey, you should use the
                official contact method provided by the developer or through the
                application store listing where Prometey was obtained.

                Contact information will be provided here before the application
                is publicly released.
            """.trimIndent(),
            primaryTextColor = primaryTextColor,
            secondaryTextColor = secondaryTextColor
        )

        Text(
            text = "PROMETEY — Your Personal AI",
            style = MaterialTheme.typography.titleMedium,
            fontWeight = FontWeight.Bold,
            color = accentColor
        )

        Text(
            text = "Privacy by design. Personal intelligence. User control.",
            style = MaterialTheme.typography.bodyMedium,
            color = secondaryTextColor
        )
    }
}

@Composable
private fun PolicySection(
    title: String,
    text: String,
    primaryTextColor: Color,
    secondaryTextColor: Color
) {
    Column(
        verticalArrangement = Arrangement.spacedBy(8.dp)
    ) {
        Text(
            text = title,
            style = MaterialTheme.typography.titleLarge,
            fontWeight = FontWeight.SemiBold,
            color = primaryTextColor
        )

        Text(
            text = text,
            style = MaterialTheme.typography.bodyLarge,
            color = secondaryTextColor
        )
    }
}