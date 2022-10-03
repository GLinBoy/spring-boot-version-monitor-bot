package com.glinboy.telegram.bot.monitorspringboot.repository

import com.glinboy.telegram.bot.monitorspringboot.entity.TelegramMessage
import org.springframework.data.jpa.repository.JpaRepository

interface TelegramMessageRepository : JpaRepository<TelegramMessage, Long> {
}
