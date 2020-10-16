package com.codebaybeaccesstest.codebaybeaccesstest.presentation.users

import com.codebaybeaccesstest.codebaybeaccesstest.domain.entities.User

fun List<User>.toCitiesDto() = map { it.toCitiesDto() }
fun User.toCitiesDto() =
        CityResponseDto(
                city = city
        )