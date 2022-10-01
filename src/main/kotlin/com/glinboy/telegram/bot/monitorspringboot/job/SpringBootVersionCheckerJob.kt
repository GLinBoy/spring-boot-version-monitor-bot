package com.glinboy.telegram.bot.monitorspringboot.job

import com.glinboy.telegram.bot.monitorspringboot.client.SpringClient
import com.glinboy.telegram.bot.monitorspringboot.dto.event.VersionEvent
import org.slf4j.LoggerFactory
import org.springframework.context.ApplicationEventPublisher
import org.springframework.scheduling.annotation.Scheduled
import org.springframework.stereotype.Component

@Component
class SpringBootVersionCheckerJob(
    val springClient: SpringClient,
    val applicationEventPublisher: ApplicationEventPublisher
) {

    private val log = LoggerFactory.getLogger(this::class.java)

    @Scheduled(cron = "\${application.cron}")
    fun execute() {
        log.info("Let's do a job!")
        springClient.getSpringMetaData()?.bootVersion?.values
            ?.filter {
                it.id?.endsWith("RELEASE", true) ?: false
            }
            ?.map {
                VersionEvent(it.name!!)
            }
            ?.forEach(applicationEventPublisher::publishEvent)
    }
}
