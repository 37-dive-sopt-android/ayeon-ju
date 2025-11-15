package com.sopt.dive.data.repositoryimpl.my

import com.sopt.dive.data.local.UserLocalDataSource
import com.sopt.dive.data.mapper.my.toDomain
import com.sopt.dive.domain.model.my.UserInfoResponseModel
import com.sopt.dive.domain.repository.my.MyPageRepository
import javax.inject.Inject

class MyPageRepositoryImpl @Inject constructor(
    private val dataSource: UserLocalDataSource
): MyPageRepository {
    override suspend fun getUserInfo(): Result<UserInfoResponseModel>
    = runCatching {
        val id = dataSource.getUserId()
        val response = dataSource.getUserInfo(id = id)
        response.data.toDomain()
    }
}