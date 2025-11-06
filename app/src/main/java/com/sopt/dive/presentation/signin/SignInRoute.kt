package com.sopt.dive.presentation.signin

import android.widget.Toast
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.text.KeyboardActions
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.focus.FocusDirection
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.platform.LocalFocusManager
import androidx.compose.ui.text.input.ImeAction
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.hilt.navigation.compose.hiltViewModel
import com.sopt.dive.core.component.button.SoptBasicButton
import com.sopt.dive.core.component.textfield.SoptBasicTextField
import com.sopt.dive.core.component.textfield.SoptPasswordTextField
import com.sopt.dive.core.util.noRippleClickable
import com.sopt.dive.data.local.UserLocalDataSource


@Composable
fun SignInRoute(
    paddingValues: PaddingValues,
    navigateToHome: () -> Unit,
    navigateToSignUp: () -> Unit,
    modifier: Modifier = Modifier,
    viewModel: SignInViewModel = hiltViewModel()
) {

    val savedId = viewModel.getUserId()
    val savedPassword = viewModel.getUserPassword()

    SignInScreen(
        savedId = savedId,
        savedPassword = savedPassword,
        paddingValues = paddingValues,
        navigateToHome = navigateToHome,
        navigateToSignUp = navigateToSignUp,
        modifier = modifier
    )
}
@Composable
fun SignInScreen(
    savedId: String,
    savedPassword: String,
    paddingValues: PaddingValues,
    navigateToHome: () -> Unit,
    navigateToSignUp: () -> Unit,
    modifier: Modifier = Modifier
) {
    val focusManger = LocalFocusManager.current
    val context = LocalContext.current

    var id by remember { mutableStateOf("") }
    var password by remember { mutableStateOf("") }

    Column(
        modifier = modifier
            .fillMaxSize()
            .background(color = Color.White)
            .padding(paddingValues)
            .padding(horizontal = 24.dp, vertical = 42.dp)
    ) {
        Text(
            text = "Welcome To SOPT",
            style = MaterialTheme.typography.headlineLarge,
            color = Color.Black,
            modifier = Modifier.align(Alignment.CenterHorizontally)
        )

        Spacer(modifier = Modifier.height(20.dp))

        Text(
            text = "ID",
            style = MaterialTheme.typography.bodyLarge,
            color = Color.Black
        )

        Spacer(modifier = Modifier.height(10.dp))

        SoptBasicTextField(
            value = id,
            onValueChange = { id = it },
            placeHolder = "아이디를 입력해주세요",
            keyboardOptions = KeyboardOptions(imeAction = ImeAction.Next),
            keyboardActions = KeyboardActions(onNext = { focusManger.moveFocus(FocusDirection.Down) })
        )

        Spacer(modifier = Modifier.height(15.dp))

        Text(
            text = "Password",
            style = MaterialTheme.typography.bodyLarge,
            color = Color.Black
        )

        Spacer(modifier = Modifier.height(10.dp))

        SoptPasswordTextField(
            value = password,
            onValueChange = { password = it },
            keyboardOptions = KeyboardOptions(imeAction = ImeAction.Done),
            keyboardActions = KeyboardActions(onDone = { focusManger.clearFocus() })
        )

        Spacer(modifier = Modifier.weight(1f))

        SoptBasicButton(
            onClick = {
                if (id == savedId && password == savedPassword && id.isNotEmpty()) {
                    Toast.makeText(context, "로그인 성공", Toast.LENGTH_SHORT).show()
                    navigateToHome()
                } else {
                    Toast.makeText(context, "아이디 또는 비밀번호가 잘못되었습니다", Toast.LENGTH_SHORT).show()
                }
            },
            text = "로그인 하기"
        )

        Text(
            text = "회원가입",
            style = MaterialTheme.typography.bodySmall,
            color = Color.LightGray,
            modifier = Modifier
                .noRippleClickable(onClick = navigateToSignUp)
                .align(Alignment.CenterHorizontally)
        )
    }
}

@Preview
@Composable
private fun SignInScreenPreview() {

}