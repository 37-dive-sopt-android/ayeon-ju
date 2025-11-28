package com.sopt.dive.data.service.home

import com.sopt.dive.data.dto.response.home.UserListResponseDto
import retrofit2.http.GET
import retrofit2.http.Headers
import retrofit2.http.Query

interface HomeService {
   @Headers("x-api-key: reqres-free-v1")
   @GET("users")
   suspend fun getHomeUserList(
        @Query("page") page: Int,
        @Query("per_page") perPage: Int
   ): UserListResponseDto
}