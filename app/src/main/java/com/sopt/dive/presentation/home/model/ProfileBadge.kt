package com.sopt.dive.presentation.home.model

enum class ProfileBadgeType(
    val badge: String
) {
    NONE(badge = ""),
    BIRTHDAY(badge = "🎂")
}

sealed class ProfileBadge(
    val profileBadgeType: ProfileBadgeType
) {
    data object None : ProfileBadge(ProfileBadgeType.NONE)
    data object BirthaDay : ProfileBadge(ProfileBadgeType.BIRTHDAY)
}