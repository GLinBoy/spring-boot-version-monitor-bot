package com.glinboy.telegram.bot.monitorspringboot.client.impl

import com.glinboy.telegram.bot.monitorspringboot.client.SpringClient
import com.glinboy.telegram.bot.monitorspringboot.dto.SpringResponseDTO
import org.springframework.beans.factory.annotation.Value
import org.springframework.boot.web.client.RestTemplateBuilder
import org.springframework.stereotype.Service
import org.springframework.web.client.RestTemplate

@Service
class SpringClientImpl: SpringClient {

    val restTemplate: RestTemplate = RestTemplateBuilder().build()

    @Value("\${application.versions-url.spring-boot}")
    lateinit var springBootUrl: String
    override fun getSpringMetaData(): SpringResponseDTO? {
        return restTemplate.getForObject(
            springBootUrl,
            SpringResponseDTO::class.java
        )
    }
}
