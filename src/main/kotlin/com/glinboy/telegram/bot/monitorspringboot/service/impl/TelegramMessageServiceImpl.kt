package com.glinboy.telegram.bot.monitorspringboot.service.impl

import com.glinboy.telegram.bot.monitorspringboot.entity.TelegramMessage
import com.glinboy.telegram.bot.monitorspringboot.repository.TelegramMessageRepository
import com.glinboy.telegram.bot.monitorspringboot.service.TelegramMessageService
import org.springframework.stereotype.Service

@Service
class TelegramMessageServiceImpl(
    private val repository: TelegramMessageRepository
) : TelegramMessageService,
    GenericServiceImpl<TelegramMessage, Long, TelegramMessageRepository>(repository) {
}
