package com.sopt.dive.presentation.signup

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
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.focus.FocusDirection
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalFocusManager
import androidx.compose.ui.text.input.ImeAction
import androidx.compose.ui.unit.dp
import androidx.hilt.navigation.compose.hiltViewModel
import com.sopt.dive.core.component.button.SoptBasicButton
import com.sopt.dive.core.component.textfield.SoptBasicTextField
import com.sopt.dive.core.component.textfield.SoptPasswordTextField


@Composable
fun SignUpRoute(
    paddingValues: PaddingValues,
    navigateToSignIn: () -> Unit,
    modifier: Modifier = Modifier,
    viewModel: SignUpViewModel = hiltViewModel(),
) {
    val uiState by viewModel.uiState.collectAsState()

    LaunchedEffect(uiState.isSuccess) {
        if (uiState.isSuccess) {
            navigateToSignIn()
            viewModel.clearErrorMessage()
        }
    }
    SignUpScreen(
        uiState = uiState,
        paddingValues = paddingValues,
        onUserNameChange = { viewModel.onUserNameChange(it) },
        onUserPasswordChange = { viewModel.onPasswordChange(it) },
        onUserNicknameChange = { viewModel.onNicknameChange(it) },
        onUserEmailChange = { viewModel.onEmailChange(it) },
        onUserAgeChange = { viewModel.onUserAgeChange(it) },
        onSignUpClick = { viewModel.onSignUpClick(uiState.username, uiState.password, uiState.name, uiState.email, uiState.age) },
        modifier = modifier
    )
}

@Composable
fun SignUpScreen(
    uiState: SignUpState,
    paddingValues: PaddingValues,
    onUserNameChange: (String) -> Unit,
    onUserPasswordChange: (String) -> Unit,
    onUserNicknameChange: (String) -> Unit,
    onUserEmailChange: (String) -> Unit,
    onUserAgeChange: (String) -> Unit,
    onSignUpClick: () -> Unit,
    modifier: Modifier = Modifier
) {
    val focusManger = LocalFocusManager.current

    Column(
        modifier = modifier
            .fillMaxSize()
            .background(color = Color.White)
            .padding(paddingValues)
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
            text = "Username",
            style = MaterialTheme.typography.bodyLarge,
            color = Color.Black
        )

        Spacer(modifier = Modifier.height(8.dp))

        SoptBasicTextField(
            value = uiState.username,
            onValueChange = onUserNameChange,
            placeHolder = "유저네임을 입력해주세요",
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
            value = uiState.password,
            onValueChange = onUserPasswordChange,
            keyboardOptions = KeyboardOptions(imeAction = ImeAction.Next),
            keyboardActions = KeyboardActions(onNext = { focusManger.moveFocus(FocusDirection.Down) })

        )

        Spacer(modifier = Modifier.height(12.dp))

        Text(
            text = "Name",
            style = MaterialTheme.typography.bodyLarge,
            color = Color.Black
        )

        Spacer(modifier = Modifier.height(8.dp))

        SoptBasicTextField(
            value = uiState.name,
            onValueChange = onUserNicknameChange,
            placeHolder = "닉네임을 입력해주세요",
            keyboardOptions = KeyboardOptions(imeAction = ImeAction.Next),
            keyboardActions = KeyboardActions(onNext = { focusManger.moveFocus(FocusDirection.Down) })
        )

        Spacer(modifier = Modifier.height(12.dp))

        Text(
            text = "Email",
            style = MaterialTheme.typography.bodyLarge,
            color = Color.Black
        )

        Spacer(modifier = Modifier.height(8.dp))

        SoptBasicTextField(
            value = uiState.email,
            onValueChange = onUserEmailChange,
            placeHolder = "이메일을 입력해주세요",
            keyboardOptions = KeyboardOptions(imeAction = ImeAction.Done),
            keyboardActions = KeyboardActions(onDone = { focusManger.clearFocus() })
        )

        Spacer(modifier = Modifier.height(12.dp))

        Text(
            text = "Age",
            style = MaterialTheme.typography.bodyLarge,
            color = Color.Black
        )

        Spacer(modifier = Modifier.height(8.dp))

        SoptBasicTextField(
            value = uiState.age,
            onValueChange = onUserAgeChange,
            placeHolder = "나이를 입력해주세요",
            keyboardOptions = KeyboardOptions(imeAction = ImeAction.Done),
            keyboardActions = KeyboardActions(onDone = { focusManger.clearFocus() })
        )

        Spacer(modifier = Modifier.weight(1f))

        SoptBasicButton(
            onClick = onSignUpClick,
            text = "회원가입",
        )
    }
}

