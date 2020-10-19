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

/**Here we just call the usersDataSource methods which contains the SQL queries and return the answers from de DB */
/**Also we transform the DAO (UserDao) format obtained from de DB to a DTO(User) format to handle it in the HTML*/
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
    /**The save method is the only one which transform de User object to a DAO to insert it into de DB*/
    override fun save(user: User) {
        usersDataSource.save(user.toUserDao())
    }

}

@Repository
interface UsersDataSource : JpaRepository<UserDao, Int> {
    /**Here we select all the users where the attribute actives is true*/
    @Query("SELECT * FROM USERS WHERE ACTIVE = TRUE",nativeQuery = true)
    fun getActiveUsers(): List<UserDao>
    /**Here we select all the users where the city name starts with the string gotten from the form*/
    @Query("SELECT * FROM USERS WHERE CITY LIKE ?1%", nativeQuery = true)
    fun getCities(city: String): List<UserDao>

    @Query("SELECT * FROM USERS ORDER BY CREATIONDATE ASC ", nativeQuery = true)
    fun getPerCreationDateAsc(): List<UserDao>

    @Query("SELECT * FROM USERS ORDER BY CREATIONDATE DESC ", nativeQuery = true)
    fun getPerCreationDateDesc(): List<UserDao>
}