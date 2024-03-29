package com.glinboy.telegram.bot.monitorspringboot.service.impl

import com.fasterxml.jackson.databind.ObjectMapper
import com.glinboy.telegram.bot.monitorspringboot.mapper.TelegramMessageMapper
import com.glinboy.telegram.bot.monitorspringboot.service.TelegramChatService
import com.glinboy.telegram.bot.monitorspringboot.service.TelegramMessageService
import com.glinboy.telegram.bot.monitorspringboot.service.TelegramService
import com.vdurmont.emoji.EmojiParser
import org.slf4j.LoggerFactory
import org.springframework.beans.factory.annotation.Value
import org.springframework.stereotype.Service
import org.telegram.telegrambots.bots.TelegramLongPollingBot
import org.telegram.telegrambots.meta.api.methods.ParseMode
import org.telegram.telegrambots.meta.api.methods.send.SendMessage
import org.telegram.telegrambots.meta.api.objects.Update
import org.telegram.telegrambots.meta.exceptions.TelegramApiException

@Service
class TelegramServiceImpl(
    private val telegramMessageService: TelegramMessageService,
    private val telegramChatService: TelegramChatService,
    private val om: ObjectMapper,

    @Value("\${application.secret.telegram-token}")
    private val token: String
) : TelegramService, TelegramLongPollingBot(token) {

    private val log = LoggerFactory.getLogger(this::class.java)

    @Value("\${application.secret.telegram-username}")
    lateinit var username: String

    @Value("\${application.release-url.spring-boot}")
    lateinit var releaseUrl: String

    override fun getBotUsername(): String = username

    override fun onUpdateReceived(update: Update?) {
        log.info(om.writeValueAsString(update))
        if (
            update?.message?.text?.equals("/start") == true ||
            update?.message?.hasText() == true
        ) {
            val message = TelegramMessageMapper.toTelegramMessage(update.message)
            telegramMessageService.save(message)
        }
    }

    override fun publishNewVersion(version: String) {
        telegramChatService.findAllChatId().forEach {
            val message = SendMessage.builder()
                .chatId(it)
                .text(
                    EmojiParser.parseToUnicode(
                        """
                            :sparkles: New version has been released :sparkles:
                            :rocket: * $version *

                            :point_right: check here: $releaseUrl$version
                        """.trimIndent()
                    )
                )
                .parseMode(ParseMode.MARKDOWN)
                .build()
            try {
                val result = execute(message)
                val msg = TelegramMessageMapper.toTelegramMessage(result)
                telegramMessageService.save(msg)
                log.info(om.writeValueAsString(result))
            } catch (ex: TelegramApiException) {
                log.error("Couldn't send message to Telegram: {}", ex.localizedMessage, ex)
            }
        }
    }
}
