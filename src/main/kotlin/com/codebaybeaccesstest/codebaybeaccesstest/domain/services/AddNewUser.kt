package com.codebaybeaccesstest.codebaybeaccesstest.domain.services

import com.codebaybeaccesstest.codebaybeaccesstest.domain.entities.User
import com.codebaybeaccesstest.codebaybeaccesstest.infrastructure.entities.UserDao
import com.codebaybeaccesstest.codebaybeaccesstest.domain.repositories.UsersRepository
import org.springframework.stereotype.Service
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RestController

@RestController
@RequestMapping("/api")
@Service
class AddNewUser (
        private val usersRepository : UsersRepository
){
    fun invoke(user: User) {
        usersRepository.save(user)
    }
}