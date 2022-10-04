package com.glinboy.telegram.bot.monitorspringboot.service.impl

import com.fasterxml.jackson.databind.ObjectMapper
import com.glinboy.telegram.bot.monitorspringboot.entity.TelegramChat
import com.glinboy.telegram.bot.monitorspringboot.entity.TelegramMessage
import com.glinboy.telegram.bot.monitorspringboot.entity.TelegramUser
import com.glinboy.telegram.bot.monitorspringboot.service.TelegramChatService
import com.glinboy.telegram.bot.monitorspringboot.service.TelegramMessageService
import com.glinboy.telegram.bot.monitorspringboot.service.TelegramService
import org.slf4j.LoggerFactory
import org.springframework.beans.factory.annotation.Value
import org.springframework.stereotype.Service
import org.telegram.telegrambots.bots.TelegramLongPollingBot
import org.telegram.telegrambots.meta.TelegramBotsApi
import org.telegram.telegrambots.meta.api.methods.send.SendMessage
import org.telegram.telegrambots.meta.api.objects.Update
import org.telegram.telegrambots.meta.exceptions.TelegramApiException
import org.telegram.telegrambots.updatesreceivers.DefaultBotSession


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
        log.info(
            "A new message from {} {} ({}): {}",
            update?.message?.messageId,
            update?.message?.from?.firstName,
            update?.message?.from?.lastName,
            update?.message?.from?.id,
            update?.message?.text
        )
    }

    override fun registerBot() {
        val telegramBotsApi = TelegramBotsApi(DefaultBotSession::class.java)
        telegramBotsApi.registerBot(this)
    }

    override fun publishNewVersion(version: String) {
        telegramChatService.findAllChatId().forEach {
            val message = SendMessage()
            message.chatId = it.toString()
            message.text = "New Version Arrived: $version"
            try {
                execute(message)
            } catch (ex: TelegramApiException) {
                log.error("Couldn't send message to Telegram: {}", ex.localizedMessage, ex)
            }
        }
    }
}
