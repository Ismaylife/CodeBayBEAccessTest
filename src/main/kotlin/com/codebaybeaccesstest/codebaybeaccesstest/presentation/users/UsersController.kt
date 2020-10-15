package com.codebaybeaccesstest.codebaybeaccesstest.presentation.users

import com.codebaybeaccesstest.codebaybeaccesstest.domain.services.GetActiveUsers
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.RestController

@RestController
class UsersController {
    @Autowired
    lateinit var getActiveUsers: GetActiveUsers


    @GetMapping("/users")
    fun getActiveUsers(): List<ActiveUserResponseDto> {
        return getActiveUsers.invoke().toActiveUsersDto()
    }
}