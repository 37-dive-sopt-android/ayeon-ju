package com.sopt.dive.presentation.signup

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
import androidx.compose.ui.unit.dp
import com.sopt.dive.core.component.button.SoptBasicButton
import com.sopt.dive.core.component.textfield.SoptBasicTextField
import com.sopt.dive.core.component.textfield.SoptPasswordTextField


@Composable
fun SignUpRoute(
    userId: String,
    userPassword: String,
    userNickname: String,
    userAlcohol: String,
    onUserIdChange: (String) -> Unit,
    onUserPasswordChange: (String) -> Unit,
    onUserNicknameChange: (String) -> Unit,
    onUserAlcoholChange: (String) -> Unit,
    navigateToSignIn: () -> Unit,
    modifier: Modifier = Modifier
) {
    SignUpScreen(
        userId = userId,
        userPassword = userPassword,
        userNickname = userNickname,
        userAlcohol = userAlcohol,
        onUserIdChange = onUserIdChange,
        onUserPasswordChange = onUserPasswordChange,
        onUserNicknameChange = onUserNicknameChange,
        onUserAlcoholChange = onUserAlcoholChange,
        navigateToSignIn = navigateToSignIn,
        modifier = modifier
    )
}

@Composable
fun SignUpScreen(
    userId: String,
    userPassword: String,
    userNickname: String,
    userAlcohol: String,
    onUserIdChange: (String) -> Unit,
    onUserPasswordChange: (String) -> Unit,
    onUserNicknameChange: (String) -> Unit,
    onUserAlcoholChange: (String) -> Unit,
    navigateToSignIn: () -> Unit,
    modifier: Modifier = Modifier
) {
    val focusManger = LocalFocusManager.current

    Column(
        modifier = modifier
            .fillMaxSize()
            .background(color = Color.White)
            .padding(horizontal = 24.dp, vertical = 14.dp)
    ) {
        Text(
            text = "회원가입",
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

        Spacer(modifier = Modifier.height(8.dp))

        SoptBasicTextField(
            value = userId,
            onValueChange = onUserIdChange,
            placeHolder = "아이디를 입력해주세요",
            keyboardOptions = KeyboardOptions(imeAction = ImeAction.Next),
            keyboardActions = KeyboardActions(onNext = { focusManger.moveFocus(FocusDirection.Down) })
        )

        Spacer(modifier = Modifier.height(12.dp))

        Text(
            text = "PW",
            style = MaterialTheme.typography.bodyLarge,
            color = Color.Black
        )

        Spacer(modifier = Modifier.height(8.dp))

        SoptPasswordTextField(
            value = userPassword,
            onValueChange = onUserPasswordChange,
            keyboardOptions = KeyboardOptions(imeAction = ImeAction.Next),
            keyboardActions = KeyboardActions(onNext = { focusManger.moveFocus(FocusDirection.Down) })

        )

        Spacer(modifier = Modifier.height(12.dp))

        Text(
            text = "NickName",
            style = MaterialTheme.typography.bodyLarge,
            color = Color.Black
        )

        Spacer(modifier = Modifier.height(8.dp))

        SoptBasicTextField(
            value = userNickname,
            onValueChange = onUserNicknameChange,
            placeHolder = "닉네임을 입력해주세요",
            keyboardOptions = KeyboardOptions(imeAction = ImeAction.Next),
            keyboardActions = KeyboardActions(onNext = { focusManger.moveFocus(FocusDirection.Down) })
        )

        Spacer(modifier = Modifier.height(12.dp))

        Text(
            text = "주량",
            style = MaterialTheme.typography.bodyLarge,
            color = Color.Black
        )

        Spacer(modifier = Modifier.height(8.dp))

        SoptBasicTextField(
            value = userAlcohol,
            onValueChange = onUserAlcoholChange,
            placeHolder = "소주 주량을 입력해주세요",
            keyboardOptions = KeyboardOptions(imeAction = ImeAction.Done),
            keyboardActions = KeyboardActions(onDone = { focusManger.clearFocus() })
        )

        Spacer(modifier = Modifier.weight(1f))

        SoptBasicButton(
            onClick = navigateToSignIn,
            text = "회원가입",
        )
    }
}

