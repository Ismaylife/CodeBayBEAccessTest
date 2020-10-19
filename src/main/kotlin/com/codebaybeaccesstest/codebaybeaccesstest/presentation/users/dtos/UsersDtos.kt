package com.codebaybeaccesstest.codebaybeaccesstest.presentation.users.dtos

data class UserResponseDto(
            val name: String,
            val surname: String,
            val active: Boolean,
            val email: String,
            val city: String,
            val birthday: String,
            val creationDate: String
    )

data class NewUserDto(
        val name: String,
        val surname: String,
        val active: Boolean,
        val email: String,
        val city: String,
        val birthday: String,
        val creationDate: String
)

data class CityResponseDto(
        val city : String
)