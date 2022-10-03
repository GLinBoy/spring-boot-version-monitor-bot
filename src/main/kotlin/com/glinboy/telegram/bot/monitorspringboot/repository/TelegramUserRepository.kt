package com.glinboy.telegram.bot.monitorspringboot.repository

import com.glinboy.telegram.bot.monitorspringboot.entity.TelegramUser
import org.springframework.data.jpa.repository.JpaRepository

interface TelegramUserRepository : JpaRepository<TelegramUser, Long> {
}
