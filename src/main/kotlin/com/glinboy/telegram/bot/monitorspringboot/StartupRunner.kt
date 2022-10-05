package com.glinboy.telegram.bot.monitorspringboot

import com.glinboy.telegram.bot.monitorspringboot.job.SpringBootVersionCheckerJob
import org.slf4j.LoggerFactory
import org.springframework.beans.factory.annotation.Value
import org.springframework.boot.context.event.ApplicationReadyEvent
import org.springframework.context.annotation.Profile
import org.springframework.context.event.EventListener
import org.springframework.stereotype.Component

@Component
@Profile("dev")
class StartupRunner(private val checker: SpringBootVersionCheckerJob) {

    private val log = LoggerFactory.getLogger(this::class.java)

    @Value("\${application.secret.telegram-token}")
    lateinit var telegramToken: String

    @EventListener(ApplicationReadyEvent::class)
    fun run() {
        log.info("Let's run some logic!")
        log.info("${telegramToken}")
        checker.execute()
    }
}
