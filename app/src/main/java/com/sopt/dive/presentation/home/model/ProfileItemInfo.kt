package com.sopt.dive.presentation.home.model

import androidx.compose.ui.graphics.Color

enum class ProfileItemType(
    val itemStyle: Color
) {
    NONE(
        itemStyle = Color.Transparent
    ),
    BIRTHDAY(
        itemStyle = Color.Blue
    ),
    MUSIC(
        itemStyle = Color.Red
    )
}

sealed class ProfileItemInfo(
    val profileItemType: ProfileItemType
) {
    data object None : ProfileItemInfo(profileItemType = ProfileItemType.NONE)
    data class Birthday(
        val title: String = "선물하기 🎁"
    ): ProfileItemInfo(profileItemType = ProfileItemType.BIRTHDAY)
    data object Music : ProfileItemInfo(profileItemType = ProfileItemType.MUSIC)
}

