package com.codebaybeaccesstest.codebaybeaccesstest.presentation.users

data class ActiveUsersResponseDto(
            val name: String,
            val surname: String,
            val active: Boolean,
            val email: String,
            val city: String,
            val birthday: String,
            val creationDate: String
    )