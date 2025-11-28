package com.sopt.dive.domain.model.my

data class UserInfoResponseModel(
    val id: Long,
    val username: String,
    val name: String,
    val email: String,
    val age: Int,
    val status: String
)