package com.glinboy.telegram.bot.monitorspringboot.dto

data class BootVersionDTO(
    val type: String? = null,
    val default: String? = null,
    val values: List<BootVersionValueDTO>? = null
)
