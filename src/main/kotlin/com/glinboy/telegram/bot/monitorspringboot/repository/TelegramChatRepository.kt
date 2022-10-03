package com.glinboy.telegram.bot.monitorspringboot.repository

import com.glinboy.telegram.bot.monitorspringboot.entity.TelegramChat
import org.springframework.data.jpa.repository.JpaRepository

interface TelegramChatRepository : JpaRepository<TelegramChat, Long> {
}
