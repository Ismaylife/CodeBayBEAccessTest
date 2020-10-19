package com.codebaybeaccesstest.codebaybeaccesstest.infrastructure.entities

import com.fasterxml.jackson.annotation.JsonProperty
import java.util.*
import javax.persistence.Column
import javax.persistence.Entity
import javax.persistence.Id
import javax.persistence.Table

@Entity
@Table(name = "users")
data class UserDao(

        @JsonProperty(value = "name")
        @Column(nullable = false)
        val name: String,

        @JsonProperty(value = "surname")
        @Column(nullable = false)
        val surname: String,

        @JsonProperty(value = "active")
        @Column(nullable = false)
        val active: Boolean,

        @Id
        @JsonProperty(value = "email")
        @Column(nullable = false)
        val email: String,

        @JsonProperty(value = "city")
        @Column(nullable = false)
        val city: String,

        @JsonProperty(value = "birthday")
        @Column(nullable = false)
        val birthday: Date,

        @JsonProperty(value = "creationDate")
        @Column(nullable = false)
        val creationDate: Date
    ) 