package com.glinboy.telegram.bot.monitorspringboot.dto

sealed class ReferenceUnionDTO {
    class HomeArrayValue(val value: List<HomeDTO>) : ReferenceUnionDTO()
    class ReferenceClassValue(val value: ReferenceClassDTO) : ReferenceUnionDTO()
}
