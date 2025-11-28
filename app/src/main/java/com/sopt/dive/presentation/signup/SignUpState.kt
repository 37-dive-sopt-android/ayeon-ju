package com.sopt.dive.presentation.signup

data class SignUpState(
    val username: String = "",
    val id: String = "",
    val password: String = "",
    val name: String = "",
    val email: String = "",
    val age: String = "",
    val isSuccess: Boolean = false,
    val errorMessage: String? = ""
)