package com.glinboy.telegram.bot.monitorspringboot.dto

data class LinksDTO(
    val mavenProject: GradleBuildClassDTO? = null,
    val mavenBuild: GradleBuildClassDTO? = null,
    val gradleProject: GradleBuildClassDTO? = null,
    val gradleBuild: GradleBuildClassDTO? = null,
    val dependencies: GradleBuildClassDTO? = null
)
