package com.sopt.dive.data.local

import android.content.SharedPreferences
import com.sopt.dive.core.util.KeyStorage.USER_ID
import com.sopt.dive.data.dto.request.auth.SignInRequestDto
import com.sopt.dive.data.dto.request.auth.SignUpRequestDto
import com.sopt.dive.data.service.auth.AuthService
import com.sopt.dive.data.service.home.HomeService
import com.sopt.dive.data.service.my.MyPageService
import jakarta.inject.Inject

class UserLocalDataSource @Inject constructor(
    private val authService: AuthService,
    private val myPageService: MyPageService,
    private val homeService: HomeService,
    private val sharedPreferences: SharedPreferences
) {

    fun getUserId(): Long {
        return sharedPreferences.getLong(USER_ID, 0L)
    }

    suspend fun postSignUp(request: SignUpRequestDto) = authService.postSignup(request = request)

    fun setUserId(id: Long) {
        sharedPreferences.edit().apply {
            putLong(USER_ID, id)
            apply()
        }
    }

    suspend fun postSignIn(request: SignInRequestDto) = authService.postSignIn(request = request)

    suspend fun getUserInfo(id: Long) = myPageService.getUserInfo(id)

    suspend fun getHomeListInfo(page: Int, perPage: Int) = homeService.getHomeUserList(page = page, perPage = perPage)
}