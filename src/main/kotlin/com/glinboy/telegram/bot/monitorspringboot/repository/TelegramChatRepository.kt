package com.glinboy.telegram.bot.monitorspringboot.repository

import com.glinboy.telegram.bot.monitorspringboot.entity.TelegramChat
import org.springframework.data.jpa.repository.JpaRepository
import org.springframework.data.jpa.repository.Query

interface TelegramChatRepository : JpaRepository<TelegramChat, Long> {
    @Query("select tc.id from TelegramChat tc")
    fun findAllIdOnly(): List<Long>
}
