package com.sopt.dive.presentation.home.model

import kotlinx.collections.immutable.persistentListOf

data class UserProfile (
    val nickname: String,
    val title: String
)

val userProfileList = persistentListOf<UserProfile>(
    UserProfile(
        nickname = "주아연",
        title = "안녕하세요"
    ),

    UserProfile(
        nickname = "정소희",
        title = "안녕???"
    ),

    UserProfile(
        nickname = "손주완",
        title = "ㅎㅇ"
    ),

    UserProfile(
        nickname = "박찬미",
        title = "안녕하세요"
    ),

    UserProfile(
        nickname = "천민재",
        title = "안녕안녕"
    ),

    UserProfile(
        nickname = "이종훈",
        title = "전 바보입니다."
    ),

    UserProfile(
        nickname = "아연",
        title = "안녕하세요"
    ),

    UserProfile(
        nickname = "소희",
        title = "나 귀여미인데?"
    )
)
