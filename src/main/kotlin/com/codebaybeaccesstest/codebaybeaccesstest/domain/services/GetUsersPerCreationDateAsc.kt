package com.codebaybeaccesstest.codebaybeaccesstest.domain.services

import com.codebaybeaccesstest.codebaybeaccesstest.domain.entities.User
import com.codebaybeaccesstest.codebaybeaccesstest.domain.repositories.UsersRepository
import org.springframework.stereotype.Service

/**This service just work as intermediary between our controller and the repository*/
@Service
class GetUsersPerCreationDateAsc(
        private val usersRepository: UsersRepository
) {
    fun invoke(): List<User> {
        return usersRepository.getPerCreationDateAsc()
    }
}