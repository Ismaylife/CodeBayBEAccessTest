package com.codebaybeaccesstest.codebaybeaccesstest.presentation.users

import com.codebaybeaccesstest.codebaybeaccesstest.domain.entities.City

fun List<City>.toCitiesDto() = map { it.toCitiesDto() }
fun City.toCitiesDto() =
        CityResponseDto(
                city = city
        )