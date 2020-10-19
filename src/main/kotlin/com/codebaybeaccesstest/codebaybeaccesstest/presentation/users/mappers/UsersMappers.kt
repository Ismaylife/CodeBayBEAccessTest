package com.codebaybeaccesstest.codebaybeaccesstest.presentation.users.mappers

import com.codebaybeaccesstest.codebaybeaccesstest.domain.entities.User
import com.codebaybeaccesstest.codebaybeaccesstest.presentation.users.dtos.CityResponseDto
import com.codebaybeaccesstest.codebaybeaccesstest.presentation.users.dtos.NewUserDto
import com.codebaybeaccesstest.codebaybeaccesstest.presentation.users.dtos.UserResponseDto
import java.text.SimpleDateFormat
import java.time.LocalDate
import java.time.ZoneId
import java.time.format.DateTimeFormatter
import java.util.*

fun List<User>.toUsersDto() = map { it.toUsersDto() }
fun User.toUsersDto() =
        UserResponseDto(
                name = name,
                surname = surname,
                active = active,
                email = email,
                city = city,
                birthday = birthday.toDateResponseDto(),
                creationDate = creationDate.toDateResponseDto()
        )

fun NewUserDto.toUser() =
        User(
                name = name,
                surname = surname,
                active = active,
                email = email,
                city = city,
                birthday = birthday.toDate(),
                creationDate = creationDate.toDate()
        )

fun List<User>.toCitiesDto() = map { it.toCitiesDto() }
fun User.toCitiesDto() =
        CityResponseDto(
                city = city
        )

fun dateToSimpleString(date: Date) : String {
        val format = SimpleDateFormat("dd/MM/yyy")
        return format.format(date)
}

fun Date.toDateResponseDto(): String =
        SimpleDateFormat("dd/MM/yyy").format(this)

fun String.toDate(): Date =
        SimpleDateFormat("dd-MM-yyyy").parse(this)