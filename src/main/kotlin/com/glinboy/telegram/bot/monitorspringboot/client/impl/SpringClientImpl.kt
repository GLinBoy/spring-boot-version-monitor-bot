package com.glinboy.telegram.bot.monitorspringboot.client.impl

import com.glinboy.telegram.bot.monitorspringboot.client.SpringClient
import org.springframework.boot.web.client.RestTemplateBuilder
import org.springframework.stereotype.Service

@Service
class SpringClientImpl: SpringClient {

    val restTemplate = RestTemplateBuilder().build()

    override fun getSpringMetaData(): String? {
        return restTemplate.getForObject(
            "https://start.spring.io/metadata/client",
            String::class.java
        )
    }
}