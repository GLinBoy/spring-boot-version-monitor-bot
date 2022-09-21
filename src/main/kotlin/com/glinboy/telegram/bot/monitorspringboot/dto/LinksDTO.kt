package com.glinboy.telegram.bot.monitorspringboot.dto

data class LinksDTO(
    val mavenProject: LinkDataDTO? = null,
    val mavenBuild: LinkDataDTO? = null,
    val gradleProject: LinkDataDTO? = null,
    val gradleBuild: LinkDataDTO? = null,
    val dependencies: LinkDataDTO? = null
)
