package com.glinboy.telegram.bot.monitorspringboot.dto

data class DependencyDataDTO(
    val name: String? = null,
    val values: List<DependencyValueDTO>? = null
)
