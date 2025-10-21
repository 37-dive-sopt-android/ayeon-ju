package com.sopt.dive.presentation.signup

import android.content.Intent
import android.os.Bundle
import android.widget.Toast
import android.widget.Toast.LENGTH_SHORT
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.imePadding
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Scaffold
import androidx.compose.material3.SnackbarHost
import androidx.compose.material3.SnackbarHostState
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.rememberCoroutineScope
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import com.sopt.dive.core.util.KeyStorage.USER_ALCOHOL
import com.sopt.dive.core.util.KeyStorage.USER_ID
import com.sopt.dive.core.util.KeyStorage.USER_NICKNAME
import com.sopt.dive.core.util.KeyStorage.USER_PASSWORD
import com.sopt.dive.data.local.UserLocalDataSource
import com.sopt.dive.ui.theme.DiveTheme
import kotlinx.coroutines.launch

class SignUpActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            DiveTheme {
                var userId by remember { mutableStateOf("") }
                var userPassword by remember { mutableStateOf("") }
                var userNickname by remember { mutableStateOf("") }
                var userAlcohol by remember { mutableStateOf("") }

                val scope = rememberCoroutineScope()
                val snackBarHostState = remember { SnackbarHostState() }

                Scaffold(
                    modifier = Modifier
                        .fillMaxSize()
                        .imePadding(),
                    snackbarHost = { SnackbarHost(hostState = snackBarHostState) }) { innerPadding ->

                    SignUpRoute(
                        userId = userId,
                        userPassword = userPassword,
                        userNickname = userNickname,
                        userAlcohol = userAlcohol,
                        onUserIdChange = { userId = it },
                        onUserPasswordChange = { userPassword = it },
                        onUserNicknameChange = { userNickname = it },
                        onUserAlcoholChange = { userAlcohol = it },
                        navigateToSignIn = {
                            val result =
                                SignUpValidation.validate(userId, userPassword, userNickname)
                            when (result) {
                                is SignUpValidationResult.Success -> {
                                    val intent = Intent().apply {
                                        putExtra(USER_ID, userId)
                                        putExtra(USER_PASSWORD, userPassword)
                                        putExtra(USER_NICKNAME, userNickname)
                                        putExtra(USER_ALCOHOL, userAlcohol)
                                    }

                                    UserLocalDataSource.saveUserInfo(
                                        userId = userId,
                                        userPassword = userPassword,
                                        userNickname = userNickname,
                                        userAlcohol = userAlcohol
                                    )
                                    Toast.makeText(this, "회원가입 성공", LENGTH_SHORT).show()
                                    setResult(RESULT_OK, intent)
                                    finish()
                                }

                                is SignUpValidationResult.Error -> {
                                    scope.launch {
                                        snackBarHostState.showSnackbar(result.message)
                                    }
                                }
                            }
                        },
                        modifier = Modifier.padding(innerPadding)
                    )
                }
            }
        }
    }
}

