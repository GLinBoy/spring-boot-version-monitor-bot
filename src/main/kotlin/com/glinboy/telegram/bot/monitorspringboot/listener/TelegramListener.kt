package com.glinboy.telegram.bot.monitorspringboot.listener

import com.glinboy.telegram.bot.monitorspringboot.dto.event.NewVersionEvent
import com.glinboy.telegram.bot.monitorspringboot.service.TelegramService
import org.slf4j.LoggerFactory
import org.springframework.context.event.EventListener
import org.springframework.stereotype.Service

@Service
class TelegramListener(
    private val telegramService: TelegramService
) {

    private val log = LoggerFactory.getLogger(this::class.java)

    @EventListener(NewVersionEvent::class)
    fun handleNewEvent(e: NewVersionEvent) {
        log.info("---> New version event arrived: ${e.version}")
        telegramService.publishNewVersion(e.version)
    }
}
