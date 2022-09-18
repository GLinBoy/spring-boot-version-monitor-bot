package com.glinboy.telegram.bot.monitorspringboot.dto

data class ValueLinkDTO(
    val reference: ReferenceUnion? = null,
    val guide: Guide? = null,
    val home: Home? = null,
    val other: Home? = null,
    val sample: Home? = null
)
