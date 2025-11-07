package com.sopt.dive.presentation.signup

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.sopt.dive.data.local.UserLocalDataSource
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.flow.update
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class SignUpViewModel @Inject constructor(
    private val userLocalDataSource: UserLocalDataSource
) : ViewModel() {

    private val _uiState = MutableStateFlow(SignUpState())
    val uiState: StateFlow<SignUpState> = _uiState.asStateFlow()

    fun onIdChange(id: String) {
        _uiState.update { it.copy(id = id) }
    }

    fun onPasswordChange(password: String) {
        _uiState.update { it.copy(password = password) }
    }

    fun onNicknameChange(nickname: String) {
        _uiState.update { it.copy(nickname = nickname) }
    }

    fun onAlcoholChange(alcohol: String) {
        _uiState.update { it.copy(alcohol = alcohol) }
    }

    fun onSignUpClick(id: String, password: String, nickname: String, alcohol: String) {
        viewModelScope.launch {
            when (val result = SignUpValidation.validate(id, password, nickname)) {
                is SignUpValidationResult.Success -> {
                    _uiState.update { it.copy(isSuccess = true, errorMessage = null) }
                    userLocalDataSource.saveUserInfo(id, password, nickname, alcohol)

                }

                is SignUpValidationResult.Error -> {
                    _uiState.update { it.copy(isSuccess = false, errorMessage = result.message) }
                }
            }
            }
        }

    fun clearErrorMessage() {
        _uiState.update { it.copy(errorMessage = null) }
    }

}



