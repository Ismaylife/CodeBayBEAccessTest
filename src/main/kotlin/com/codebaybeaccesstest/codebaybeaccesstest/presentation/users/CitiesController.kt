package com.codebaybeaccesstest.codebaybeaccesstest.presentation.users

import com.codebaybeaccesstest.codebaybeaccesstest.domain.services.GetCities
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.RestController

@RestController
class CitiesController {
    @Autowired
    lateinit var getCities: GetCities


    @GetMapping("/cities")
    fun getCities(): List<CityResponseDto> {
        return getCities.invoke().toCitiesDto()
    }
}