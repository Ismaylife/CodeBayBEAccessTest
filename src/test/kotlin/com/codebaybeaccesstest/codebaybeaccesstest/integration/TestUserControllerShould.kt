package com.codebaybeaccesstest.codebaybeaccesstest.integration

import com.codebaybeaccesstest.codebaybeaccesstest.domain.entities.User
import com.codebaybeaccesstest.codebaybeaccesstest.domain.repositories.UsersRepository
import com.codebaybeaccesstest.codebaybeaccesstest.presentation.users.ActiveUserResponseDto
import com.fasterxml.jackson.module.kotlin.jacksonObjectMapper
import com.fasterxml.jackson.module.kotlin.readValue
import org.junit.jupiter.api.BeforeEach
import org.junit.jupiter.api.Test
import org.mockito.Mockito.`when`
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.test.web.servlet.MockMvc
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders
import java.util.*
import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.extension.ExtendWith
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc
import org.springframework.boot.test.context.SpringBootTest
import org.springframework.boot.test.mock.mockito.MockBean
import org.springframework.test.context.ContextConfiguration
import org.springframework.test.context.junit.jupiter.SpringExtension
import org.springframework.test.web.servlet.MvcResult
import org.springframework.test.web.servlet.result.MockMvcResultMatchers

@SpringBootTest
@ExtendWith(SpringExtension::class)
@ContextConfiguration
@AutoConfigureMockMvc
class TestUserControllerShould {
    @Autowired
    lateinit var mvc: MockMvc

    @MockBean
    lateinit var usersRepository: UsersRepository

    private val mockedUsers = listOf(
            User(
                    name = "irrelevant",
                    surname = "irrelevant",
                    active = true,
                    email = "irrelevant",
                    city = "irrelevant",
                    birthday = Date(),
                    creationDate = Date())
    )

    @BeforeEach
    fun setup() {
        `when`(usersRepository.getActiveUsers()).thenReturn(mockedUsers)
    }

    @Test
    fun retrieve_a_list_of_active_users() {
        val result: MvcResult = mvc.perform(MockMvcRequestBuilders.get("/users"))
                .andExpect(ok())
                .andReturn()

        val activeUsersResponse = jsonTo<List<ActiveUserResponseDto>>(result.response.contentAsString)

        for ((index,user) in activeUsersResponse.withIndex()) {
            assertThat(user.name).isEqualTo(mockedUsers[index].name)
        }
    }

    private inline fun <reified T> jsonTo(json: String) = jacksonObjectMapper().readValue<T>(json)

    fun ok() = MockMvcResultMatchers.status().isOk
}