package com.sopt.dive.presentation.my

import com.sopt.dive.domain.model.my.UserInfoResponseModel

data class UserInfoState(
    val userInfo: UserInfoResponseModel? = null

)

sealed interface UserInfoSideEffect {
    data object Success: UserInfoSideEffect
    data class ShowErrorMessage(val message: String): UserInfoSideEffect
}
