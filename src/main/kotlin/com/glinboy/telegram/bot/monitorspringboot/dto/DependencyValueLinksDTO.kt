package com.glinboy.telegram.bot.monitorspringboot.dto

data class DependencyValueLinksDTO(
    val reference: ReferenceUnionDTO?,
    val guide: GuideDTO?,
    val home: HomeDTO?,
    val other: HomeDTO?,
    val sample: HomeDTO?
)
