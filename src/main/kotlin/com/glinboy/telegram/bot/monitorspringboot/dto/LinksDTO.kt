package com.glinboy.telegram.bot.monitorspringboot.dto

data class LinksDTO(
    val mavenProject: LinkDataDTO?,
    val mavenBuild: LinkDataDTO?,
    val gradleProject: LinkDataDTO?,
    val gradleBuild: LinkDataDTO?,
    val dependencies: LinkDataDTO?
)
