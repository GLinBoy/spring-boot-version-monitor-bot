package com.glinboy.telegram.bot.monitorspringboot.dto

import com.fasterxml.jackson.annotation.JsonProperty

data class DependencyValueDTO(
    val id: String?,
    val name: String?,
    val description: String?,
    val versionRange: String?,
    @JsonProperty("_links") val links: DependencyValueLinksDTO?
)
