package com.glinboy.telegram.bot.monitorspringboot.dto

import com.fasterxml.jackson.annotation.JsonProperty

data class SpringResponseDTO(
    @JsonProperty("_links") val links: LinksDTO?,
    /**
     * We don't need this properties now
     * and unfortunately there is an strange error under this property
     */
//    val dependencies: DependenciesDTO?,
    val type: DataDTO?,
    val packaging: DataDTO?,
    val javaVersion: DataDTO?,
    val language: DataDTO?,
    val bootVersion: DataDTO?,
    val groupID: DataDTO?,
    val artifactID: DataDTO?,
    val version: DataDTO?,
    val name: DataDTO?,
    val description: DataDTO?,
    val packageName: DataDTO?
)
