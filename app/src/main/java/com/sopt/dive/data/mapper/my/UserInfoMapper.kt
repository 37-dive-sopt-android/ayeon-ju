package com.sopt.dive.data.mapper.my

import com.sopt.dive.data.dto.response.my.UserInfoResponseDto
import com.sopt.dive.domain.model.my.UserInfoResponseModel

fun UserInfoResponseDto.toDomain() = UserInfoResponseModel(
    id = this.id,
    username = this.username,
    name = this.name,
    email = this.email,
    age = this.age,
    status = this.status
)