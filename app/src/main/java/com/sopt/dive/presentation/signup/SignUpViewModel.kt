package com.sopt.dive.presentation.signup

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.sopt.dive.domain.model.auth.SignUpRequestModel
import com.sopt.dive.domain.repository.auth.AuthRepository
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.flow.update
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class SignUpViewModel @Inject constructor(
    private val authRepository: AuthRepository
) : ViewModel() {

    private val _uiState = MutableStateFlow(SignUpState())
    val uiState: StateFlow<SignUpState> = _uiState.asStateFlow()

    fun onUserNameChange(username: String) {
        _uiState.update { it.copy(username = username) }
    }

    fun onPasswordChange(password: String) {
        _uiState.update { it.copy(password = password) }
    }

    fun onNicknameChange(nickname: String) {
        _uiState.update { it.copy(name = nickname) }
    }

    fun onEmailChange(email: String) {
        _uiState.update { it.copy(email = email) }
    }

    fun onUserAgeChange(age: String) {
        _uiState.update { it.copy(age = age) }
    }

    fun onSignUpClick(username: String, password: String, name: String, email: String, age: String) {
        viewModelScope.launch {
            when (val result = SignUpValidation.validate(username, password, name, email)) {
                is SignUpValidationResult.Success -> {
                    _uiState.update { it.copy(isSuccess = true, errorMessage = null) }
                    authRepository.postSignUp(request = SignUpRequestModel(
                        username = username,
                        password = password,
                        name = name,
                        email = email,
                        age = age.toInt(),
                    )
                  ).onFailure {  }
                    //userLocalDataSource.saveUserInfo(id, password, nickname, alcohol)

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



