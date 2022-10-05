package com.glinboy.telegram.bot.monitorspringboot.listener

import com.glinboy.telegram.bot.monitorspringboot.dto.event.NewVersionEvent
import com.glinboy.telegram.bot.monitorspringboot.dto.event.VersionEvent
import com.glinboy.telegram.bot.monitorspringboot.service.LatestVersionService
import org.slf4j.LoggerFactory
import org.springframework.context.ApplicationEventPublisher
import org.springframework.context.event.EventListener
import org.springframework.stereotype.Service

@Service
class VersionListener(
    val latestVersionService: LatestVersionService,
    val applicationEventPublisher: ApplicationEventPublisher
) {

    private val log = LoggerFactory.getLogger(this::class.java)

    @EventListener(VersionEvent::class)
    fun handleNewEvent(e: VersionEvent) {
        log.info("---> New event arrived: ${e.version}")
        if (latestVersionService.isLatestVersion(e.version)) {
            applicationEventPublisher.publishEvent(NewVersionEvent(e.version))
        }
    }
}
