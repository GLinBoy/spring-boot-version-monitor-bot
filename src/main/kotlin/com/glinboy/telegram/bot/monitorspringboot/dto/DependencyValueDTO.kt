package com.glinboy.telegram.bot.monitorspringboot.dto

data class DependencyValueDTO(
    val id: String? = null,
    val name: String? = null,
    val description: String? = null,
    val versionRange: String? = null,
    val links: DependencyValueLinksDTO? = null
)
