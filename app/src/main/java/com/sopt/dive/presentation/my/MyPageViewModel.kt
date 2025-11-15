package com.sopt.dive.presentation.my

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.sopt.dive.data.local.UserLocalDataSource
import com.sopt.dive.domain.repository.my.MyPageRepository
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
class MyPageViewModel @Inject constructor(
    private val myPageRepository: MyPageRepository
) : ViewModel() {
    private val _uiState = MutableStateFlow(UserInfoState())
    val uiState: StateFlow<UserInfoState> = _uiState.asStateFlow()

    private val _sideEffect = MutableSharedFlow<UserInfoSideEffect>()
    val sideEffect = _sideEffect.asSharedFlow()

    init {
        loadUserInfo()
    }

    fun loadUserInfo() {
        viewModelScope.launch {
            myPageRepository.getUserInfo()
                .onSuccess { userInfo ->
                    _uiState.update {
                        it.copy(userInfo = userInfo)
                    }
                    _sideEffect.emit(UserInfoSideEffect.Success)
                }
                .onFailure {
                    _sideEffect.emit(UserInfoSideEffect.ShowErrorMessage("내 정보 불러오기 실패"))
                }
        }
    }
}