package com.codebaybeaccesstest.codebaybeaccesstest.infrastructure.entities.mappers

import com.codebaybeaccesstest.codebaybeaccesstest.domain.entities.User
import com.codebaybeaccesstest.codebaybeaccesstest.infrastructure.entities.UserDao

/**Our converters between User and Dao and vice versa*/
fun List<User>.toUserDao() = map { it.toUserDao() }
fun User.toUserDao() =
        UserDao(
                name = name,
                surname = surname,
                active = active,
                email = email,
                city = city,
                birthday = birthday,
                creationDate = creationDate
        )

fun List<UserDao>.toUser()= map { it.toUser() }
fun UserDao.toUser() =
        User(
                name = name,
                surname = surname,
                active = active,
                email = email,
                city = city,
                birthday = birthday,
                creationDate = creationDate
        )
