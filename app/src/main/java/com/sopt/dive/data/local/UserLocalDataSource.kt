package com.sopt.dive.data.local

import android.content.SharedPreferences
import com.sopt.dive.core.util.KeyStorage.USER_ALCOHOL
import com.sopt.dive.core.util.KeyStorage.USER_ID
import com.sopt.dive.core.util.KeyStorage.USER_NICKNAME
import com.sopt.dive.core.util.KeyStorage.USER_PASSWORD
import jakarta.inject.Inject

class UserLocalDataSource @Inject constructor(
    private val sharedPreferences: SharedPreferences
) {
    fun saveUserInfo(
        userId: String,
        userPassword: String,
        userNickname: String,
        userAlcohol: String,
    ) {
        sharedPreferences.edit().apply {
            putString(USER_ID, userId)
            putString(USER_PASSWORD, userPassword)
            putString(USER_NICKNAME, userNickname)
            putString(USER_ALCOHOL, userAlcohol)
            apply()
        }
    }

    fun getUserId(): String {
        return sharedPreferences.getString(USER_ID, null) ?: ""
    }

    fun getUserPassword(): String {
        return sharedPreferences.getString(USER_PASSWORD, null) ?: ""
    }

    fun getUserNickname(): String {
        return sharedPreferences.getString(USER_NICKNAME, null) ?: ""
    }

    fun getUserAlcohol(): String {
        return sharedPreferences.getString(USER_ALCOHOL, null) ?: ""
    }
}