package com.codebaybeaccesstest.codebaybeaccesstest.domain.services

import com.codebaybeaccesstest.codebaybeaccesstest.domain.entities.User
import com.codebaybeaccesstest.codebaybeaccesstest.infrastructure.entities.UserDao
import com.codebaybeaccesstest.codebaybeaccesstest.domain.repositories.UsersRepository
import org.springframework.stereotype.Service

@Service
class GetUsersPerCreationDateAsc(
        private val usersRepository : UsersRepository
) {

    fun invoke(): List<User> {
        return usersRepository.getPerCreationDateAsc()
    }
}