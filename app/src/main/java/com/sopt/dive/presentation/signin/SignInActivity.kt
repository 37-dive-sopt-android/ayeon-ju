package com.sopt.dive.presentation.signin

import android.content.Intent
import android.os.Bundle
import android.widget.Toast
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.activity.result.contract.ActivityResultContracts
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Scaffold
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import com.sopt.dive.presentation.home.HomeActivity
import com.sopt.dive.presentation.main.MainActivity.Companion.USER_ALCOHOL
import com.sopt.dive.presentation.main.MainActivity.Companion.USER_ID
import com.sopt.dive.presentation.main.MainActivity.Companion.USER_NICKNAME
import com.sopt.dive.presentation.main.MainActivity.Companion.USER_PASSWORD
import com.sopt.dive.presentation.signup.SignUpActivity
import com.sopt.dive.ui.theme.DiveTheme

class SignInActivity : ComponentActivity() {

    private var userId = ""
    private var userPassword = ""
    private var userNickname = ""
    private var userAlcohol = ""

    private val signUpResult =
        registerForActivityResult(ActivityResultContracts.StartActivityForResult()) { result ->
            if (result.resultCode == RESULT_OK) {
                val data = result.data
                userId = data?.getStringExtra(USER_ID).orEmpty()
                userPassword = data?.getStringExtra(USER_PASSWORD).orEmpty()
                userNickname = data?.getStringExtra(USER_NICKNAME).orEmpty()
                userAlcohol = data?.getStringExtra(USER_ALCOHOL).orEmpty()

            }
        }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {

            DiveTheme {
                Scaffold(
                    modifier = Modifier.fillMaxSize()
                ) { innerPadding ->

                    var id by remember { mutableStateOf("") }
                    var password by remember { mutableStateOf("") }

                    SignInRoute(
                        id = id,
                        password = password,
                        onIdChange = { id = it },
                        onPasswordChange = { password = it },
                        onSignInButtonClick = { onSignInButtonClick(id = id, password = password) },
                        navigateToSignUp = { navigateToSignUp() },
                        modifier = Modifier.padding(innerPadding)
                    )
                }
            }
        }
    }

    private fun onSignInButtonClick(
        id: String, password: String
    ) {
        if (id == userId && password == userPassword && id.isNotEmpty() && password.isNotEmpty()) {

            val intent = Intent(this, HomeActivity::class.java).apply {
                putExtra(USER_ID, id)
                putExtra(USER_PASSWORD, password)
                putExtra(USER_NICKNAME, userNickname)
                putExtra(USER_ALCOHOL, userAlcohol)

            }

            Toast.makeText(this, "로그인 성공", Toast.LENGTH_SHORT).show()
            startActivity(intent)
            finish()

        } else {
            Toast.makeText(this, "아이디와 비밀번호가 옳지 않습니다.", Toast.LENGTH_SHORT).show()
        }
    }

    private fun navigateToSignUp() {
        signUpResult.launch(Intent(this, SignUpActivity::class.java))
    }
}

