package com.sopt.dive.presentation.main

import android.content.Intent
import android.os.Bundle
import androidx.activity.ComponentActivity
import com.sopt.dive.data.local.UserLocalDataSource
import com.sopt.dive.presentation.home.HomeActivity
import com.sopt.dive.presentation.signin.SignInActivity

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        UserLocalDataSource.init(this)

        val isLoggedIn = UserLocalDataSource.isLoggedIn()

        val intent = if (isLoggedIn) {
            Intent(this, HomeActivity::class.java)
        } else Intent(this, SignInActivity::class.java).apply {
            Intent.FLAG_ACTIVITY_CLEAR_TASK
        }
        startActivity(intent)
        finish()
    }
}