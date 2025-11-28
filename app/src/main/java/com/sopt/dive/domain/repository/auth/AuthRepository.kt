package com.sopt.dive.domain.repository.auth

import com.sopt.dive.domain.model.auth.SignInRequestModel
import com.sopt.dive.domain.model.auth.SignUpRequestModel

interface AuthRepository {
    suspend fun postSignUp(request: SignUpRequestModel): Result<Unit>
    suspend fun postSignIn(request: SignInRequestModel): Result<Unit>
}