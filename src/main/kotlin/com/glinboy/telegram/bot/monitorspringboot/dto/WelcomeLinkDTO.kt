package com.glinboy.telegram.bot.monitorspringboot.dto

data class WelcomeLinkDTO(
    val mavenProject: GradleBuildClass? = null,
    val mavenBuild: GradleBuildClass? = null,
    val gradleProject: GradleBuildClass? = null,
    val gradleBuild: GradleBuildClass? = null,
    val dependencies: GradleBuildClass? = null
)
