package com.sopt.dive.presentation.signup

sealed interface SignUpValidationResult {
    object Success : SignUpValidationResult

    sealed interface Error: SignUpValidationResult {
        val message: String

        data object InvalidUsername : Error {
            override val message = "닉네임은 최대 50글자로 입력해 주세요."
        }

        data object InvalidUserPassword : Error {
            override val message = "비밀번호를 8~12글자로 입력해 주세요."
        }

        data object InvalidUserNickname : Error {
            override val message = "닉네임은 공백 없이 입력해주세요."
        }

        data object InvalidEmail : Error {
            override val message = "이메일은 공백 없이 입력해주세요."
        }
    }
}
object SignUpValidation {
    fun validate(
        username: String,
        userPassword: String,
        name: String,
        email: String
    ): SignUpValidationResult {
        return when {
            username.length !in 6..50 -> SignUpValidationResult.Error.InvalidUsername
            userPassword.length !in 8..64 -> SignUpValidationResult.Error.InvalidUserPassword
            name.isBlank() -> SignUpValidationResult.Error.InvalidUserNickname
            email.isBlank() -> SignUpValidationResult.Error.InvalidEmail
            else -> SignUpValidationResult.Success
        }
    }
}