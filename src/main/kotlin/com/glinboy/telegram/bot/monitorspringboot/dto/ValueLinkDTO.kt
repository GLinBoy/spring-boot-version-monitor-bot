package com.glinboy.telegram.bot.monitorspringboot.dto

data class ValueLinkDTO(
    val reference: ReferenceUnionDTO? = null,
    val guide: GuideDTO? = null,
    val home: HomeDTO? = null,
    val other: HomeDTO? = null,
    val sample: HomeDTO? = null
)
