package com.glinboy.telegram.bot.monitorspringboot.entity

import jakarta.persistence.Entity
import jakarta.persistence.Id

@Entity
data class TelegramChat(
    @Id val id: Long? = null,
    val type: String? = null,
    val firstname: String? = null,
    val lastname: String? = null,
    val username: String? = null
)
