package com.sopt.dive.presentation.signin

import androidx.lifecycle.ViewModel
import com.sopt.dive.data.local.UserLocalDataSource
import dagger.hilt.android.lifecycle.HiltViewModel
import javax.inject.Inject

@HiltViewModel
class SignInViewModel @Inject constructor(
    private val userLocalDataSource: UserLocalDataSource
): ViewModel() {

    fun getUserId(): String = userLocalDataSource.getUserId()

    fun getUserPassword(): String = userLocalDataSource.getUserPassword()
}