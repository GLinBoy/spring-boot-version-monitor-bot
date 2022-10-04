package com.glinboy.telegram.bot.monitorspringboot.service

import com.glinboy.telegram.bot.monitorspringboot.entity.TelegramChat

interface TelegramChatService : GenericService<TelegramChat, Long> {
    fun findAllChatId(): List<Long>
}
