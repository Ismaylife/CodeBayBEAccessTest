package com.codebaybeaccesstest.codebaybeaccesstest.presentation.users

import com.codebaybeaccesstest.codebaybeaccesstest.domain.entities.User
import java.text.SimpleDateFormat
import java.util.*

fun List<User>.toActiveUsersDto() = map { it.toActiveUsersDto() }
fun User.toActiveUsersDto() =
        ActiveUserResponseDto(
                name = name,
                surname = surname,
                active = active,
                email = email,
                city = city,
                birthday = toSimpleString(birthday),
                creationDate = toSimpleString(creationDate)
        )

fun toSimpleString(date: Date) : String {
        val format = SimpleDateFormat("dd/MM/yyy")
        return format.format(date)
}