package com.codebaybeaccesstest.codebaybeaccesstest.presentation.users

import com.codebaybeaccesstest.codebaybeaccesstest.domain.entities.User

fun List<User>.toActiveUsersDto() = map { it.toActiveUsersDto() }
fun User.toActiveUsersDto() =
        ActiveUserResponseDto(
                name = name,
                surname = surname,
                active = active,
                email = email,
                city = city,
                birthday = "aaa",
                creationDate = "aaa"
        )