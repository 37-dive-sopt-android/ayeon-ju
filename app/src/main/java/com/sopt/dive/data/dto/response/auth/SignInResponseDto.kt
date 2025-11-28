package com.sopt.dive.data.dto.response.auth

import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Serializable
data class SignInResponseDto(
    @SerialName("userId")
    val userId: Long,
    @SerialName("message")
    val message: String
)
