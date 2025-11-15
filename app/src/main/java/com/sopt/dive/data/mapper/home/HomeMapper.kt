package com.sopt.dive.data.mapper.home

import com.sopt.dive.data.dto.response.home.ListInfoResponseDto
import com.sopt.dive.domain.model.home.ListInfoResponseModel

fun ListInfoResponseDto.toDomain() = ListInfoResponseModel(
    id = this.id,
    email = this.email,
    firstname = this.firstname,
    lastname = this.lastname,
    avatar = this.avatar
)

fun List<ListInfoResponseDto>.toDomainList() = this.map { it.toDomain() }