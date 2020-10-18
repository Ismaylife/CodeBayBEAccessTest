package com.codebaybeaccesstest.codebaybeaccesstest.domain.repositories

import com.codebaybeaccesstest.codebaybeaccesstest.domain.entities.User
import org.springframework.data.jpa.repository.JpaRepository
import org.springframework.data.jpa.repository.Query
import org.springframework.stereotype.Repository


@Repository
interface UsersRepository : JpaRepository<User, Long> {
    @Query("select u from User u where u.active = true")
    fun getActiveUsers(): List<User>

    @Query("SELECT * FROM USERS WHERE CITY LIKE ?1%", nativeQuery = true)
    fun getCities(city : String): List<User>

    @Query("SELECT * FROM USERS ORDER BY CREATIONDATE ASC ", nativeQuery = true)
    fun getPerCreationDateAsc(): List<User>

    @Query("SELECT * FROM USERS ORDER BY CREATIONDATE DESC ", nativeQuery = true)
    fun getPerCreationDateDesc(): List<User>
    }
