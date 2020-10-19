package com.codebaybeaccesstest.codebaybeaccesstest.domain.repositories

import com.codebaybeaccesstest.codebaybeaccesstest.domain.entities.User


interface UsersRepository {
    fun getActiveUsers(): List<User>
    fun getCities(city: String): List<User>
    fun getPerCreationDateAsc(): List<User>
    fun getPerCreationDateDesc(): List<User>
    fun save(user: User)
}
