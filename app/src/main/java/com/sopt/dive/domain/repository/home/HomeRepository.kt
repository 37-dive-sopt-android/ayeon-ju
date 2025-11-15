package com.sopt.dive.domain.repository.home

import com.sopt.dive.domain.model.home.ListInfoResponseModel

interface HomeRepository {
    suspend fun getHomeUserList(page: Int, perPage: Int): Result<List<ListInfoResponseModel>>
}