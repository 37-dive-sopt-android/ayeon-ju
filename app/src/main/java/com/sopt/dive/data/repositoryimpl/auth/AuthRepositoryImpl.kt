package com.sopt.dive.data.repositoryimpl.auth

import com.sopt.dive.data.local.UserLocalDataSource
import com.sopt.dive.data.mapper.auth.toDto
import com.sopt.dive.domain.model.auth.SignUpRequestModel
import com.sopt.dive.domain.repository.auth.AuthRepository
import javax.inject.Inject

class AuthRepositoryImpl @Inject constructor(
    private val dataSource: UserLocalDataSource
) : AuthRepository {
    override suspend fun postSignUp(request: SignUpRequestModel): Result<Unit>
    = runCatching {
        dataSource.postSignUp(request.toDto())
    }
}