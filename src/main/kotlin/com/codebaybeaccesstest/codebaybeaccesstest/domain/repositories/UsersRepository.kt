package com.codebaybeaccesstest.codebaybeaccesstest.domain.repositories

import com.codebaybeaccesstest.codebaybeaccesstest.domain.entities.City
import com.codebaybeaccesstest.codebaybeaccesstest.domain.entities.User

interface UsersRepository {
        fun getActiveUsers(): List<User>

        fun getCities(): List<City>
    }