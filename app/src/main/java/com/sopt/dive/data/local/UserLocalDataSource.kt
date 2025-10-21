package com.sopt.dive.data.local

import android.content.Context
import android.content.SharedPreferences
import com.sopt.dive.core.util.KeyStorage.IS_LOGGED_IN
import com.sopt.dive.core.util.KeyStorage.USER_ALCOHOL
import com.sopt.dive.core.util.KeyStorage.USER_ID
import com.sopt.dive.core.util.KeyStorage.USER_NICKNAME
import com.sopt.dive.core.util.KeyStorage.USER_PASSWORD
import com.sopt.dive.core.util.KeyStorage.USER_PREFS

object UserLocalDataSource {

    private lateinit var userPrefs: SharedPreferences

    fun init(context: Context) {
        userPrefs = context.getSharedPreferences(USER_PREFS, Context.MODE_PRIVATE)
    }

    fun isLoggedIn(): Boolean {
        return userPrefs.getBoolean(IS_LOGGED_IN, false)
    }

    fun saveUserInfo(
        userId: String,
        userPassword: String,
        userNickname: String,
        userAlcohol: String,
        isLoggedIn: Boolean = false
    ) {
        userPrefs.edit().apply {
            putString(USER_ID, userId)
            putString(USER_PASSWORD, userPassword)
            putString(USER_NICKNAME, userNickname)
            putString(USER_ALCOHOL, userAlcohol)
            putBoolean(IS_LOGGED_IN, isLoggedIn)
            apply()
        }
    }

    fun getUserId(): String {
        return userPrefs.getString(USER_ID, null) ?: ""
    }

    fun getUserPassword(): String {
        return userPrefs.getString(USER_PASSWORD, null) ?: ""
    }

    fun getUserNickname(): String {
        return userPrefs.getString(USER_NICKNAME, null) ?: ""
    }

    fun getUserAlcohol(): String {
        return userPrefs.getString(USER_ALCOHOL, null) ?: ""
    }
}