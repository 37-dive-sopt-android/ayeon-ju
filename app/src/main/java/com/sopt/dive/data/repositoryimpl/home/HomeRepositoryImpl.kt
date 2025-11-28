package com.sopt.dive.data.repositoryimpl.home

import com.sopt.dive.data.local.UserLocalDataSource
import com.sopt.dive.domain.model.home.ListInfoResponseModel
import com.sopt.dive.domain.repository.home.HomeRepository
import com.sopt.dive.data.mapper.home.toDomainList
import javax.inject.Inject

class HomeRepositoryImpl @Inject constructor(
    private val dataSource: UserLocalDataSource
): HomeRepository {
    override suspend fun getHomeUserList(page: Int, perPage: Int): Result<List<ListInfoResponseModel>>
    = runCatching {
        val response = dataSource.getHomeListInfo(page = page, perPage = perPage)
        response.data.toDomainList()
    }
}