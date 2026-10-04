package com.xxlionxx.prometey.presentation.events

import com.xxlionxx.prometey.domain.model.User
import com.xxlionxx.prometey.domain.model.UserProfile

sealed interface ProfileEvent : MviEvent {

    data class LoadUser(val userId: String) : ProfileEvent

    data class LoadProfile(val userId: String) : ProfileEvent

    data class SaveUser(val user: User) : ProfileEvent

    data class UpdateUser(val user: User) : ProfileEvent

    data class SaveProfile(val profile: UserProfile) : ProfileEvent

    data class UpdateProfile(val profile: UserProfile) : ProfileEvent

    data object ClearProfile : ProfileEvent
}