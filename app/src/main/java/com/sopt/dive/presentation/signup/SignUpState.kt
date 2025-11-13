package com.sopt.dive.presentation.signup

data class SignUpState(
    val id: String = "",
    val password: String = "",
    val nickname: String = "",
    val alcohol: String = "",
    val isSuccess: Boolean = false,
    val errorMessage: String? = ""
)