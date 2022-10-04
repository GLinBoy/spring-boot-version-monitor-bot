package com.glinboy.telegram.bot.monitorspringboot.service.impl

import com.glinboy.telegram.bot.monitorspringboot.entity.TelegramUser
import com.glinboy.telegram.bot.monitorspringboot.repository.TelegramUserRepository
import com.glinboy.telegram.bot.monitorspringboot.service.TelegramUserService
import org.springframework.stereotype.Service

@Service
class TelegramUserServiceImpl(
    private val repository: TelegramUserRepository
) : TelegramUserService,
    GenericServiceImpl<TelegramUser, Long, TelegramUserRepository>(repository) {
}
