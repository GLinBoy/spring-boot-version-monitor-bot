package com.glinboy.telegram.bot.monitorspringboot.dto

import com.fasterxml.jackson.annotation.JsonProperty

data class DependencyValueDTO(
    val id: String? = null,
    val name: String? = null,
    val description: String? = null,
    val versionRange: String? = null,
    @JsonProperty("_links") val links: DependencyValueLinksDTO? = null
)
