package com.sopt.dive.domain.repository.my

import com.sopt.dive.domain.model.my.UserInfoResponseModel

interface MyPageRepository {
    suspend fun getUserInfo(): Result<UserInfoResponseModel>
}