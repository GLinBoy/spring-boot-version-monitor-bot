package com.glinboy.telegram.bot.monitorspringboot.service.impl

import com.fasterxml.jackson.databind.ObjectMapper
import com.glinboy.telegram.bot.monitorspringboot.entity.TelegramChat
import com.glinboy.telegram.bot.monitorspringboot.entity.TelegramMessage
import com.glinboy.telegram.bot.monitorspringboot.entity.TelegramUser
import com.glinboy.telegram.bot.monitorspringboot.service.TelegramChatService
import com.glinboy.telegram.bot.monitorspringboot.service.TelegramMessageService
import com.glinboy.telegram.bot.monitorspringboot.service.TelegramService
import com.vdurmont.emoji.EmojiParser
import org.slf4j.LoggerFactory
import org.springframework.beans.factory.annotation.Value
import org.springframework.stereotype.Service
import org.telegram.telegrambots.bots.TelegramLongPollingBot
import org.telegram.telegrambots.meta.api.methods.send.SendMessage
import org.telegram.telegrambots.meta.api.objects.Update
import org.telegram.telegrambots.meta.exceptions.TelegramApiException


@Service
class TelegramServiceImpl(
    private val telegramMessageService: TelegramMessageService,
    private val telegramChatService: TelegramChatService,
    private val om: ObjectMapper
) : TelegramService, TelegramLongPollingBot() {

    private val log = LoggerFactory.getLogger(this::class.java)

    @Value("\${application.secret.telegram-token}")
    lateinit var token: String

    @Value("\${application.secret.telegram-username}")
    lateinit var username: String

    @Value("\${application.release-url.spring-boot}")
    lateinit var releaseUrl: String

    override fun getBotToken(): String = token

    override fun getBotUsername(): String = username

    override fun onUpdateReceived(update: Update?) {
        log.info(om.writeValueAsString(update))
        val message = TelegramMessage(
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
        telegramMessageService.save(message)
    }

    override fun publishNewVersion(version: String) {
        telegramChatService.findAllChatId().forEach {
            val message = SendMessage.builder()
                .chatId(it)
                .text(
                    EmojiParser.parseToUnicode(
                        """
                            :sparkles: New version has been released :sparkles:
                            :rocket: $version

                            :point_right: check here: $releaseUrl$version
                        """.trimIndent()
                    )
                )
                .build()
            try {
                val result = execute(message)
                log.info(om.writeValueAsString(result))
            } catch (ex: TelegramApiException) {
                log.error("Couldn't send message to Telegram: {}", ex.localizedMessage, ex)
            }
        }
    }
}
