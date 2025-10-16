package com.sopt.dive.presentation.home

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Scaffold
import androidx.compose.ui.Modifier
import com.sopt.dive.presentation.main.MainActivity.Companion.USER_ALCOHOL
import com.sopt.dive.presentation.main.MainActivity.Companion.USER_ID
import com.sopt.dive.presentation.main.MainActivity.Companion.USER_NICKNAME
import com.sopt.dive.presentation.main.MainActivity.Companion.USER_PASSWORD
import com.sopt.dive.ui.theme.DiveTheme

class HomeActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            DiveTheme {
                Scaffold(modifier = Modifier.fillMaxSize()) { innerPadding ->

                    val userId = intent.getStringExtra(USER_ID).orEmpty()
                    val userPassword = intent.getStringExtra(USER_PASSWORD).orEmpty()
                    val userNickname = intent.getStringExtra(USER_NICKNAME).orEmpty()
                    val userAlcohol = intent.getStringExtra(USER_ALCOHOL).orEmpty()

                    HomeRoute(
                        userId = userId,
                        userPassword = userPassword,
                        nickname = userNickname,
                        userAlcohol = userAlcohol,
                        modifier = Modifier.padding(innerPadding)
                    )
                }
            }
        }
    }
}

