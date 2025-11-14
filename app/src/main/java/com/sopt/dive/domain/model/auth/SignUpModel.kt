package com.sopt.dive.domain.model.auth

data class SignUpRequestModel(
    val username: String,
    val password: String,
    val name: String,
    val email: String,
    val age: Int
)
data class SignUpResponseModel(
    val id: Int,
    val username: String,
    val name: String,
    val email: String,
    val age: Int,
    val status: String
)
