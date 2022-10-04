package com.glinboy.telegram.bot.monitorspringboot.service

import org.springframework.boot.context.event.ApplicationReadyEvent
import org.springframework.context.event.EventListener

interface TelegramService {

    @EventListener(ApplicationReadyEvent::class)
    fun registerBot()

    fun publishNewVersion(version: String)
}
