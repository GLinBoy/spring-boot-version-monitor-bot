package com.glinboy.telegram.bot.monitorspringboot.dto

data class ValueDTO(
    val id: String?,
    val name: String?,
    val description: String?,
    val action: String?,
    val tags: TagsDTO?
)
