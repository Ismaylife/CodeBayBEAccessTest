package com.codebaybeaccesstest.codebaybeaccesstest.domain.entities

import java.util.*

data class User(
        val name: String,
        val surname: String,
        val active: Boolean,
        val email: String,
        val city: String,
        val birthday: Date,
        val creationDate: Date
    ) 