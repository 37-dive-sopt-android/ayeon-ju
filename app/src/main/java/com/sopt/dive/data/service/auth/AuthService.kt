package com.sopt.dive.data.service.auth

import com.sopt.dive.data.dto.request.auth.SignUpRequestDto
import com.sopt.dive.data.dto.response.BaseResponse
import com.sopt.dive.data.dto.response.auth.SignUpResponseDto
import retrofit2.http.Body
import retrofit2.http.POST

interface AuthService {
    @POST("/api/v1/users")
    suspend fun postSignup(
        @Body request: SignUpRequestDto
    ): BaseResponse<SignUpResponseDto>
}