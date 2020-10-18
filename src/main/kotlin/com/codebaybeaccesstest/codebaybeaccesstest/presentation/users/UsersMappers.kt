package com.codebaybeaccesstest.codebaybeaccesstest.presentation.users

import com.codebaybeaccesstest.codebaybeaccesstest.domain.entities.User
import java.text.SimpleDateFormat
import java.util.*

fun List<User>.toUsersDto() = map { it.toUsersDto() }
fun User.toUsersDto() =
        UserResponseDto(
                name = name,
                surname = surname,
                active = active,
                email = email,
                city = city,
                birthday = dateToSimpleString(birthday),
                creationDate = dateToSimpleString(creationDate)
        )

fun dateToSimpleString(date: Date) : String {
        val format = SimpleDateFormat("dd/MM/yyy")
        return format.format(date)
}