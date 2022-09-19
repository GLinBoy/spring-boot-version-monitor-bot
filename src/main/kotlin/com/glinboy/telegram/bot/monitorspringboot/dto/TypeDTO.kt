package com.glinboy.telegram.bot.monitorspringboot.dto

data class TypeDTO(
    val type: String? = null,
    val default: String? = null,
    val values: List<TypeValueDTO>? = null
)
