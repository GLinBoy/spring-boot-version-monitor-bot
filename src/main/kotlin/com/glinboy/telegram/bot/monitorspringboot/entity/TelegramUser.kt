package com.glinboy.telegram.bot.monitorspringboot.entity

import javax.persistence.Entity
import javax.persistence.Id

@Entity
data class TelegramUser(
    @Id val id: Long? = null,
    val firstname: String? = null,
    val lastname: String? = null,
    val username: String? = null,
    val languageCode: String? = null,
    val isBot: Boolean? = false
)
