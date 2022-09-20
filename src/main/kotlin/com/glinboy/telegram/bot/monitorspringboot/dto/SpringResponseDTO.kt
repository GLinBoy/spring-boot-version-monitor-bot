package com.glinboy.telegram.bot.monitorspringboot.dto

import com.fasterxml.jackson.annotation.JsonProperty

data class SpringResponseDTO(
    @JsonProperty("_links") val links: LinksDTO? = null,
    val dependencies: DependenciesDTO? = null,
    val type: DataDTO? = null,
    val packaging: DataDTO? = null,
    val javaVersion: DataDTO? = null,
    val language: DataDTO? = null,
    val bootVersion: DataDTO? = null,
    val groupID: DataDTO? = null,
    val artifactID: DataDTO? = null,
    val version: DataDTO? = null,
    val name: DataDTO? = null,
    val description: DataDTO? = null,
    val packageName: DataDTO? = null
)
