package com.sopt.dive.presentation.main

import android.content.Intent
import android.os.Bundle
import androidx.activity.ComponentActivity
import com.sopt.dive.presentation.signin.SignInActivity

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        val intent = Intent(this, SignInActivity::class.java).apply {
            Intent.FLAG_ACTIVITY_CLEAR_TASK
        }

        startActivity(intent)
    }

    companion object {
        const val USER_ID = "user_id"
        const val USER_PASSWORD = "user_password"
        const val USER_NICKNAME = "user_nickname"
        const val USER_ALCOHOL = "user_alcohol"
        const val USER_PREFS = "user_preferences"
        const val IS_LOGGED_IN = "is_logged_in"
    }
}