package com.sopt.dive.presentation.signup

sealed interface SignUpValidationResult {
    object SignUpSuccess : SignUpValidationResult

    sealed class InvalidItem(val message: String) : SignUpValidationResult {
        object InvalidUserId : InvalidItem("아이디를 6~10글자로 입력해 주세요.")
        object InvalidUserPassword : InvalidItem("비밀번호를 8~12글자로 입력해 주세요.")
        object InvalidUserNickname : InvalidItem("닉네임은 공백 없이 입력해주세요.")
    }
}
object SignUpValidation {
    fun validate(
        userId: String,
        userPassword: String,
        userNickname: String
    ): SignUpValidationResult {
        return when {
            userId.length !in 6..10 -> SignUpValidationResult.InvalidItem.InvalidUserId
            userPassword.length !in 8..12 -> SignUpValidationResult.InvalidItem.InvalidUserPassword
            userNickname.isBlank() -> SignUpValidationResult.InvalidItem.InvalidUserNickname
            else -> SignUpValidationResult.SignUpSuccess
        }
    }
}