package com.sopt.dive.presentation.home

import com.sopt.dive.domain.model.home.ListInfoResponseModel

data class HomeState(
    val users: List<ListInfoResponseModel> = emptyList()
)