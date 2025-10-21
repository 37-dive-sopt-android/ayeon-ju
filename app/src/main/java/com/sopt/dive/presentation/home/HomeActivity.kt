package com.sopt.dive.presentation.home

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Scaffold
import androidx.compose.ui.Modifier
import com.sopt.dive.core.util.KeyStorage.IS_LOGGED_IN
import com.sopt.dive.core.util.KeyStorage.USER_ALCOHOL
import com.sopt.dive.core.util.KeyStorage.USER_ID
import com.sopt.dive.core.util.KeyStorage.USER_NICKNAME
import com.sopt.dive.core.util.KeyStorage.USER_PASSWORD
import com.sopt.dive.data.local.UserLocalDataSource
import com.sopt.dive.ui.theme.DiveTheme

class HomeActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            DiveTheme {
                Scaffold(modifier = Modifier.fillMaxSize()) { innerPadding ->

                    var userId = intent.getStringExtra(USER_ID).orEmpty()
                    var userPassword = intent.getStringExtra(USER_PASSWORD).orEmpty()
                    var userNickname = intent.getStringExtra(USER_NICKNAME).orEmpty()
                    var userAlcohol = intent.getStringExtra(USER_ALCOHOL).orEmpty()

                    if (intent.getBooleanExtra(IS_LOGGED_IN, true)) {
                        userId = UserLocalDataSource.getUserId()
                        userPassword = UserLocalDataSource.getUserPassword()
                        userNickname = UserLocalDataSource.getUserNickname()
                        userAlcohol = UserLocalDataSource.getUserAlcohol()
                    }

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

