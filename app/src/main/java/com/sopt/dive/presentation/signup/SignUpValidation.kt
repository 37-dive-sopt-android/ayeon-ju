package com.sopt.dive.presentation.signup

sealed interface SignUpValidationResult {
    object Success : SignUpValidationResult

    sealed interface Error: SignUpValidationResult {
        val message: String

        data object InvalidUserId : Error {
            override val message = "아이디를 6~10글자로 입력해 주세요."
        }

        data object InvalidUserPassword : Error {
            override val message = "비밀번호를 8~12글자로 입력해 주세요."
        }

        data object InvalidUserNickname : Error {
            override val message = "닉네임은 공백 없이 입력해주세요."
        }
    }
}
object SignUpValidation {
    fun validate(
        userId: String,
        userPassword: String,
        userNickname: String
    ): SignUpValidationResult {
        return when {
            userId.length !in 6..10 -> SignUpValidationResult.Error.InvalidUserId
            userPassword.length !in 8..12 -> SignUpValidationResult.Error.InvalidUserPassword
            userNickname.isBlank() -> SignUpValidationResult.Error.InvalidUserNickname
            else -> SignUpValidationResult.Success
        }
    }
}