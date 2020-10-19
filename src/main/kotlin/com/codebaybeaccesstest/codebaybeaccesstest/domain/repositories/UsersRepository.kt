package com.codebaybeaccesstest.codebaybeaccesstest.domain.repositories

import com.codebaybeaccesstest.codebaybeaccesstest.domain.entities.User

/**In this case, our repository is very clean because it is overridden by the UsersRepositoryImpl at the infrastructure package*/
/**We do it like this to have decoupled layers (in case we need to change or DB for example)*/
interface UsersRepository {
    fun getActiveUsers(): List<User>
    fun getCities(city: String): List<User>
    fun getPerCreationDateAsc(): List<User>
    fun getPerCreationDateDesc(): List<User>
    fun save(user: User)
}
