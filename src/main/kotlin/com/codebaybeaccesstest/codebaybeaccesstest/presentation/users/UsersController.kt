package com.codebaybeaccesstest.codebaybeaccesstest.presentation.users

import com.codebaybeaccesstest.codebaybeaccesstest.domain.services.*
import com.codebaybeaccesstest.codebaybeaccesstest.presentation.users.dtos.CityResponseDto
import com.codebaybeaccesstest.codebaybeaccesstest.presentation.users.dtos.NewUserDto
import com.codebaybeaccesstest.codebaybeaccesstest.presentation.users.dtos.UserResponseDto
import com.codebaybeaccesstest.codebaybeaccesstest.presentation.users.mappers.toCitiesDto
import com.codebaybeaccesstest.codebaybeaccesstest.presentation.users.mappers.toUser
import com.codebaybeaccesstest.codebaybeaccesstest.presentation.users.mappers.toUsersDto
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.web.bind.annotation.*


class UsersController {
    @Autowired
    lateinit var getActiveUsers: GetActiveUsers

    @GetMapping("/users")
    fun getActiveUsers(): List<UserResponseDto> {
        return getActiveUsers.invoke().toUsersDto()
    }

    @Autowired
    lateinit var getUsersPerCreationDateAsc: GetUsersPerCreationDateAsc

    @GetMapping("/users/creationDateAsc")
    fun getUsersPerCreationDateAsc(): List<UserResponseDto> {
        return getUsersPerCreationDateAsc.invoke().toUsersDto()
    }

    @Autowired
    lateinit var getUsersPerCreationDateDesc: GetUsersPerCreationDateAsc

    @GetMapping("/users/creationDateDesc")
    fun getUsersPerCreationDateDes(): List<UserResponseDto> {
        return getUsersPerCreationDateDesc.invoke().toUsersDto()
    }

    @Autowired
    lateinit var getCities: GetCities

    @GetMapping("/users/{city}")
    fun getCities(@RequestParam city : String): List<CityResponseDto> {
        return getCities.invoke(city).toCitiesDto()
    }

    @Autowired
    lateinit var addNewUser: AddNewUser

    @PostMapping("/users")
    fun addNewUser(@RequestBody newUser : NewUserDto){
        addNewUser.invoke(newUser.toUser())
    }
}