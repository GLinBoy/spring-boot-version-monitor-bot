package com.glinboy.telegram.bot.monitorspringboot.dto

data class SpringResponseDTO(
    val links: WelcomeLinkDTO? = null,
    val dependencies: WelcomeDependencyDTO? = null,
    val type: TypeDTO? = null,
    val packaging: BootVersionDTO? = null,
    val javaVersion: BootVersionDTO? = null,
    val language: BootVersionDTO? = null,
    val bootVersion: BootVersionDTO? = null,
    val groupID: ArtifactIdDTO? = null,
    val artifactID: ArtifactIdDTO? = null,
    val version: ArtifactIdDTO? = null,
    val name: ArtifactIdDTO? = null,
    val description: ArtifactIdDTO? = null,
    val packageName: ArtifactIdDTO? = null
)
