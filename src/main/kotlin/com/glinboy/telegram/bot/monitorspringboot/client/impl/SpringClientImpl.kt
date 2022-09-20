package com.glinboy.telegram.bot.monitorspringboot.client.impl

import com.glinboy.telegram.bot.monitorspringboot.client.SpringClient
import com.glinboy.telegram.bot.monitorspringboot.dto.SpringResponseDTO
import org.springframework.boot.web.client.RestTemplateBuilder
import org.springframework.stereotype.Service

@Service
class SpringClientImpl: SpringClient {

    val restTemplate = RestTemplateBuilder().build()

    override fun getSpringMetaData(): SpringResponseDTO? {
        return restTemplate.getForObject(
            "https://start.spring.io/metadata/client",
            SpringResponseDTO::class.java
        )
    }
}
