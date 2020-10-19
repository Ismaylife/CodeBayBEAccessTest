package com.codebaybeaccesstest.codebaybeaccesstest.domain.services

import com.codebaybeaccesstest.codebaybeaccesstest.domain.entities.User
import com.codebaybeaccesstest.codebaybeaccesstest.infrastructure.entities.UserDao
import com.codebaybeaccesstest.codebaybeaccesstest.domain.repositories.UsersRepository
import org.springframework.stereotype.Service

@Service
class GetCities (
    private val usersRepository : UsersRepository
){
        fun invoke(city: String): List<User> {
            return usersRepository.getCities(city)
        }
}