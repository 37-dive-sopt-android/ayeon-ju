package com.sopt.dive.data.service.my

import com.sopt.dive.data.dto.response.BaseResponse
import com.sopt.dive.data.dto.response.my.UserInfoResponseDto
import retrofit2.http.GET
import retrofit2.http.Path

interface MyPageService {
    @GET("/api/v1/users/{id}")
    suspend fun getUserInfo(
        @Path("id") id: Long
    ): BaseResponse<UserInfoResponseDto>
}