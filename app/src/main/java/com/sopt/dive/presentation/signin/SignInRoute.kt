package com.sopt.dive.presentation.signin

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.text.KeyboardActions
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.focus.FocusDirection
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalFocusManager
import androidx.compose.ui.text.input.ImeAction
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.sopt.dive.core.component.button.SoptBasicButton
import com.sopt.dive.core.component.textfield.SoptBasicTextField
import com.sopt.dive.core.component.textfield.SoptPasswordTextField
import com.sopt.dive.core.util.noRippleClickable


@Composable
fun SignInRoute(
    id: String,
    password: String,
    onIdChange: (String) -> Unit,
    onPasswordChange: (String) -> Unit,
    onSignInButtonClick: () -> Unit,
    navigateToSignUp: () -> Unit,
    modifier: Modifier = Modifier
) {
    SignInScreen(
        id = id,
        password = password,
        onIdChange = onIdChange,
        onPasswordChange = onPasswordChange,
        onSignInButtonClick = onSignInButtonClick,
        navigateToSignUp = navigateToSignUp,
        modifier = modifier
    )
}
@Composable
fun SignInScreen(
    id: String,
    password: String,
    onIdChange: (String) -> Unit,
    onPasswordChange: (String) -> Unit,
    onSignInButtonClick: () -> Unit,
    navigateToSignUp: () -> Unit,
    modifier: Modifier = Modifier
) {
    val focusManger = LocalFocusManager.current

    Column(
        modifier = modifier
            .fillMaxSize()
            .background(color = Color.White)
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
            onValueChange = onIdChange,
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
            onValueChange = onPasswordChange,
            keyboardOptions = KeyboardOptions(imeAction = ImeAction.Done),
            keyboardActions = KeyboardActions(onDone = { focusManger.clearFocus() })
        )

        Spacer(modifier = Modifier.weight(1f))

        SoptBasicButton(
            onClick = onSignInButtonClick,
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
    SignInScreen(
        id = "",
        password = "",
        onIdChange = {},
        onPasswordChange = {},
        onSignInButtonClick = {},
        navigateToSignUp = {}
    )
}