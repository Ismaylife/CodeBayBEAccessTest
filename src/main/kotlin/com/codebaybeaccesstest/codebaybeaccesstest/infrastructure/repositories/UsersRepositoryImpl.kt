package com.codebaybeaccesstest.codebaybeaccesstest.infrastructure.repositories

import com.codebaybeaccesstest.codebaybeaccesstest.domain.entities.User
import com.codebaybeaccesstest.codebaybeaccesstest.infrastructure.entities.UserDao
import com.codebaybeaccesstest.codebaybeaccesstest.domain.repositories.UsersRepository
import com.codebaybeaccesstest.codebaybeaccesstest.infrastructure.entities.mappers.toUser
import com.codebaybeaccesstest.codebaybeaccesstest.infrastructure.entities.mappers.toUserDao
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.data.jpa.repository.JpaRepository
import org.springframework.data.jpa.repository.Query
import org.springframework.stereotype.Repository

@Repository
class UsersRepositoryImpl(
        @Autowired private val usersDataSource: UsersDataSource
) : UsersRepository {
    override fun getActiveUsers(): List<User> {
        return usersDataSource.getActiveUsers().toUser()
    }

    override fun getCities(city: String): List<User> {
        return usersDataSource.getCities(city).toUser()
    }

    override fun getPerCreationDateAsc(): List<User> {
        return usersDataSource.getPerCreationDateAsc().toUser()
    }

    override fun getPerCreationDateDesc(): List<User> {
        return usersDataSource.getPerCreationDateDesc().toUser()

    }

    override fun save(user: User) {
        usersDataSource.save(user.toUserDao())
    }

}

@Repository
interface UsersDataSource : JpaRepository<UserDao, Int> {
    @Query("select u from User u where u.active = true")
    fun getActiveUsers(): List<UserDao>

    @Query("SELECT * FROM USERS WHERE CITY LIKE ?1%", nativeQuery = true)
    fun getCities(city: String): List<UserDao>

    @Query("SELECT * FROM USERS ORDER BY CREATIONDATE ASC ", nativeQuery = true)
    fun getPerCreationDateAsc(): List<UserDao>

    @Query("SELECT * FROM USERS ORDER BY CREATIONDATE DESC ", nativeQuery = true)
    fun getPerCreationDateDesc(): List<UserDao>
}