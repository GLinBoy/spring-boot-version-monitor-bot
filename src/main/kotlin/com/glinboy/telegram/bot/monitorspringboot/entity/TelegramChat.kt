package com.glinboy.telegram.bot.monitorspringboot.entity

import javax.persistence.Entity
import javax.persistence.Id

@Entity
data class TelegramChat(
    @Id val id: Long? = null,
    val type: String? = null,
    val firstname: String? = null,
    val lastname: String? = null,
    val username: String? = null
)
