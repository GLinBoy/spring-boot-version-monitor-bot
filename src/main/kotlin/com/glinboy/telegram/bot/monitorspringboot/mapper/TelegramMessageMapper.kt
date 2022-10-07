package com.glinboy.telegram.bot.monitorspringboot.mapper

import com.glinboy.telegram.bot.monitorspringboot.entity.TelegramChat
import com.glinboy.telegram.bot.monitorspringboot.entity.TelegramMessage
import com.glinboy.telegram.bot.monitorspringboot.entity.TelegramUser
import org.telegram.telegrambots.meta.api.objects.Message

class TelegramMessageMapper {
    companion object {
        fun toTelegramMessage(message: Message?): TelegramMessage {
            return TelegramMessage(
                message?.messageId?.toLong(),
                TelegramUser(
                    message?.from?.id,
                    message?.from?.firstName,
                    message?.from?.lastName,
                    message?.from?.userName,
                    message?.from?.languageCode,
                    message?.from?.isBot
                ),
                TelegramChat(
                    message?.chat?.id,
                    message?.chat?.type,
                    message?.chat?.firstName,
                    message?.chat?.lastName,
                    message?.chat?.userName,
                ),
                message?.date?.toLong(),
                message?.text
            )
        }
    }
}
