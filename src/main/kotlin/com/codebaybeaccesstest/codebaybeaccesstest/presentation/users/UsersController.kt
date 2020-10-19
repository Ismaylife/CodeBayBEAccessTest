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

/**The UsersController will connect all our services with the HTML(client) requests*/
class UsersController {
    /**Use @Autowired to inject dependencies of our services in the controller */
    @Autowired
    lateinit var getActiveUsers: GetActiveUsers
    /**Use the @GetMapping to ask for a determinated user. We call the function getActiveUsers wich returns a list of User DTOs to easy handle it at the HTML*/
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
/** In this case, we need a text parameter to realize a search in the DB*/
    @GetMapping("/users/{city}")
    fun getCities(@RequestParam city : String): List<CityResponseDto> {
        return getCities.invoke(city).toCitiesDto()
    }

    @Autowired
    lateinit var addNewUser: AddNewUser
    /** In this case, we are doing a @RequestBody to take parameters from a form and save a new User in the DB*/
    @PostMapping("/users")
    fun addNewUser(@RequestBody newUser : NewUserDto){
        addNewUser.invoke(newUser.toUser())
    }
}