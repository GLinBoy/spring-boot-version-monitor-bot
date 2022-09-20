package com.glinboy.telegram.bot.monitorspringboot.dto

data class DataDTO(
    val type: String? = null,
    val default: String? = null,
    val values: List<ValueDTO>? = null
)
