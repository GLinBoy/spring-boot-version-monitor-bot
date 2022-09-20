package com.glinboy.telegram.bot.monitorspringboot.client

import com.glinboy.telegram.bot.monitorspringboot.dto.SpringResponseDTO

interface SpringClient {
    fun getSpringMetaData(): SpringResponseDTO?
}
