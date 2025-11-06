package com.sopt.dive.presentation.my

import androidx.lifecycle.ViewModel
import com.sopt.dive.data.local.UserLocalDataSource
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.asStateFlow
import javax.inject.Inject

@HiltViewModel
class MyPageViewModel @Inject constructor(
    private val userLocalDataSource: UserLocalDataSource
) : ViewModel() {
    private val _uiState = MutableStateFlow(UserInfoState())
    val uiState: StateFlow<UserInfoState> = _uiState.asStateFlow()

    init {
        loadUserInfo()
    }

    private fun loadUserInfo() {
        _uiState.value = UserInfoState(
            userId = userLocalDataSource.getUserId(),
            userPassword = userLocalDataSource.getUserPassword(),
            userNickname = userLocalDataSource.getUserNickname(),
            userAlcohol = userLocalDataSource.getUserAlcohol()
        )
    }
}