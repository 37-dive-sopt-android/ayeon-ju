package com.sopt.dive.presentation.signin

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
import androidx.compose.ui.unit.dp
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.lifecycle.compose.collectAsStateWithLifecycle
import com.sopt.dive.core.component.button.SoptBasicButton
import com.sopt.dive.core.component.textfield.SoptBasicTextField
import com.sopt.dive.core.component.textfield.SoptPasswordTextField
import com.sopt.dive.core.designsystem.LocalAppSnackbarHostState
import com.sopt.dive.core.util.noRippleClickable

@Composable
fun SignInRoute(
    paddingValues: PaddingValues,
    navigateToHome: () -> Unit,
    navigateToSignUp: () -> Unit,
    modifier: Modifier = Modifier,
    viewModel: SignInViewModel = hiltViewModel()
) {
    val uiState by viewModel.uiState.collectAsStateWithLifecycle()
    val showSnackBar = LocalAppSnackbarHostState.current

    LaunchedEffect(Unit) {
        viewModel.sideEffect.collect { effect ->
            when (effect) {
                SignInSideEffect.Success -> navigateToHome()
                is SignInSideEffect.ShowErrorMessage -> showSnackBar(effect.message)
            }
        }
    }

    SignInScreen(
        uiState = uiState,
        paddingValues = paddingValues,
        onUsernameChange = viewModel::onUsernameChange,
        onPasswordChange = viewModel::onPasswordChange,
        onSignInClick = { viewModel.onSignInClick() },
        navigateToHome = navigateToHome,
        navigateToSignUp = navigateToSignUp,
        modifier = modifier
    )
}

@Composable
fun SignInScreen(
    uiState: SignInState,
    paddingValues: PaddingValues,
    onUsernameChange: (String) -> Unit,
    onPasswordChange: (String) -> Unit,
    onSignInClick: () -> Unit,
    navigateToHome: () -> Unit,
    navigateToSignUp: () -> Unit,
    modifier: Modifier = Modifier
) {
    val focusManger = LocalFocusManager.current
    val context = LocalContext.current

    var username by remember { mutableStateOf("") }
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
            text = "USERNAME",
            style = MaterialTheme.typography.bodyLarge,
            color = Color.Black
        )

        Spacer(modifier = Modifier.height(10.dp))

        SoptBasicTextField(
            value = uiState.username,
            onValueChange = onUsernameChange,
            placeHolder = "username을 입력해주세요",
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
            value = uiState.password,
            onValueChange = onPasswordChange,
            keyboardOptions = KeyboardOptions(imeAction = ImeAction.Done),
            keyboardActions = KeyboardActions(onDone = { focusManger.clearFocus() })
        )

        Spacer(modifier = Modifier.weight(1f))

        SoptBasicButton(
            onClick = onSignInClick,
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

