package com.glinboy.telegram.bot.monitorspringboot.mapper

import com.glinboy.telegram.bot.monitorspringboot.entity.TelegramChat
import com.glinboy.telegram.bot.monitorspringboot.entity.TelegramMessage
import com.glinboy.telegram.bot.monitorspringboot.entity.TelegramUser
import org.telegram.telegrambots.meta.api.objects.Update

class TelegramMessageMapper {
    companion object {
        fun toTelegramMessage(update: Update?): TelegramMessage {
            return TelegramMessage(
                update?.message?.messageId?.toLong(),
                TelegramUser(
                    update?.message?.from?.id,
                    update?.message?.from?.firstName,
                    update?.message?.from?.lastName,
                    update?.message?.from?.userName,
                    update?.message?.from?.languageCode,
                    update?.message?.from?.isBot
                ),
                TelegramChat(
                    update?.message?.chat?.id,
                    update?.message?.chat?.type,
                    update?.message?.chat?.firstName,
                    update?.message?.chat?.lastName,
                    update?.message?.chat?.userName,
                ),
                update?.message?.date?.toLong(),
                update?.message?.text
            )
        }
    }
}
