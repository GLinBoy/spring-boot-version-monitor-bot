package com.glinboy.telegram.bot.monitorspringboot.entity

import jakarta.persistence.*

@Entity
data class TelegramMessage(
    @Id val messageId: Long? = null,
    @ManyToOne(cascade = [CascadeType.ALL])
    @JoinColumn(
        name = "user_id", nullable = false,
        foreignKey = ForeignKey(name = "fk_user_message")
    )
    val from: TelegramUser? = null,
    @ManyToOne(cascade = [CascadeType.ALL])
    @JoinColumn(
        name = "chat_id", nullable = false,
        foreignKey = ForeignKey(name = "fk_chat_message")
    )
    val chat: TelegramChat? = null,
    val date: Long? = null,
    val text: String? = null
)
