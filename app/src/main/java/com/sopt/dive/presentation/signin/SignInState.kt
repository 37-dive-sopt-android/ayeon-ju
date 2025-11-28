package com.sopt.dive.presentation.signin

data class SignInState(
    val username: String = "",
    val password: String = ""
)

sealed interface SignInSideEffect {
    data object Success: SignInSideEffect
    data class ShowErrorMessage(val message: String): SignInSideEffect
}
