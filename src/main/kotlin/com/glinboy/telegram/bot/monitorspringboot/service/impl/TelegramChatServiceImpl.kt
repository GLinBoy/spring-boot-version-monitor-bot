package com.glinboy.telegram.bot.monitorspringboot.service.impl

import com.glinboy.telegram.bot.monitorspringboot.entity.TelegramChat
import com.glinboy.telegram.bot.monitorspringboot.repository.TelegramChatRepository
import com.glinboy.telegram.bot.monitorspringboot.service.TelegramChatService
import org.springframework.stereotype.Service

@Service
class TelegramChatServiceImpl(
    private val repository: TelegramChatRepository
) : TelegramChatService,
    GenericServiceImpl<TelegramChat, Long, TelegramChatRepository>(repository){
    override fun findAllChatId(): List<Long> = repository.findAllIdOnly()
}
