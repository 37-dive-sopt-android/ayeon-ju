package com.sopt.dive.data.mapper.auth

import com.sopt.dive.data.dto.request.auth.SignInRequestDto
import com.sopt.dive.data.dto.request.auth.SignUpRequestDto
import com.sopt.dive.domain.model.auth.SignInRequestModel
import com.sopt.dive.domain.model.auth.SignUpRequestModel

fun SignUpRequestModel.toDto() = SignUpRequestDto(
    username = this.username,
    password = this.password,
    name = this.name,
    email = this.email,
    age = this.age
)

fun SignInRequestModel.toDto() = SignInRequestDto(
    username = this.username,
    password = this.password
)