package com.glinboy.telegram.bot.monitorspringboot

import org.springframework.boot.autoconfigure.SpringBootApplication
import org.springframework.boot.runApplication
import org.springframework.scheduling.annotation.EnableScheduling

@EnableScheduling
@SpringBootApplication
class MonitorSpringBootApplication

fun main(args: Array<String>) {
    runApplication<MonitorSpringBootApplication>(*args)
}
