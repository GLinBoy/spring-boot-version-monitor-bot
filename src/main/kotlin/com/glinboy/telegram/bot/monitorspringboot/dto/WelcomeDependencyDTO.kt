package com.glinboy.telegram.bot.monitorspringboot.dto

data class WelcomeDependencyDTO(
    val type: String? = null,
    val values: List<DependenciesValueDTO>? = null
)
