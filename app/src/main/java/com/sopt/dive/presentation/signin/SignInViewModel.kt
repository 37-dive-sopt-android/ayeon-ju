package com.sopt.dive.presentation.signin

import android.widget.Toast
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.sopt.dive.data.local.UserLocalDataSource
import com.sopt.dive.data.repositoryimpl.auth.AuthRepositoryImpl
import com.sopt.dive.domain.model.auth.SignInRequestModel
import com.sopt.dive.domain.repository.auth.AuthRepository
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.MutableSharedFlow
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.asSharedFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.flow.update
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class SignInViewModel @Inject constructor(
    private val authRepository: AuthRepository
): ViewModel() {

    private val _uiState = MutableStateFlow(SignInState())
    val uiState : StateFlow<SignInState> = _uiState.asStateFlow()

    private val _sideEffect = MutableSharedFlow<SignInSideEffect>()
    val sideEffect = _sideEffect.asSharedFlow()

    fun onUsernameChange(username: String) =
        _uiState.update { it.copy(username = username) }

    fun onPasswordChange(password: String) =
        _uiState.update { it.copy(password = password) }

    fun onSignInClick() {
        with(_uiState.value) {
            if (username.isBlank() || password.isBlank()) {
                viewModelScope.launch {
                    _sideEffect.emit(SignInSideEffect.ShowErrorMessage("nickname 또는 password를 입력해 주세요."))
                }
                return
            }

            viewModelScope.launch {
                authRepository.postSignIn(
                    SignInRequestModel(
                        username = username,
                        password = password
                    )
                ).onSuccess {
                    _sideEffect.emit(SignInSideEffect.Success)
                }.onFailure {
                    _sideEffect.emit(SignInSideEffect.ShowErrorMessage("로그인 실패"))
                }
            }

        }

    }
}