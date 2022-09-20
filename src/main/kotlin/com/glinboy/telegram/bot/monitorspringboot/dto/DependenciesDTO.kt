package com.glinboy.telegram.bot.monitorspringboot.dto

data class DependenciesDTO(
    val type: String? = null,
    val values: List<DependenciesValueDTO>? = null
)
