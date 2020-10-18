package com.codebaybeaccesstest.codebaybeaccesstest.presentation.users

import com.codebaybeaccesstest.codebaybeaccesstest.domain.entities.User
import com.codebaybeaccesstest.codebaybeaccesstest.domain.repositories.UsersRepository
import com.codebaybeaccesstest.codebaybeaccesstest.domain.services.*
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.web.bind.annotation.*


class UsersController(private val usersRepository: UsersRepository) {
    @Autowired
    lateinit var getActiveUsers: GetActiveUsers


    @GetMapping("/users")
    fun getActiveUsers(): List<UserResponseDto> {
        return getActiveUsers.invoke().toUsersDto()
    }

    @Autowired
    lateinit var getUsersPerCreationDateAsc: GetUsersPerCreationDateAsc


    @GetMapping("/users/{creationDate}")
    fun getUsersPerCreationDateAsc(): List<UserResponseDto> {
        return getUsersPerCreationDateAsc.invoke().toUsersDto()
    }

    @Autowired
    lateinit var getUsersPerCreationDateDesc: GetUsersPerCreationDateAsc


    @GetMapping("/users/{creationDate}")
    fun getUsersPerCreationDateDes(): List<UserResponseDto> {
        return getUsersPerCreationDateDesc.invoke().toUsersDto()
    }

    @Autowired
    lateinit var getCities: GetCities


    @GetMapping("/users/{city}")
    fun getCities(@RequestBody city : String): List<CityResponseDto> {
        return getCities.invoke(city).toCitiesDto()
    }

    @Autowired
    lateinit var addNewUser: AddNewUser


    @PostMapping("/users")
    fun addNewUser(@RequestBody user : User){
        addNewUser.invoke(user)
    }

}