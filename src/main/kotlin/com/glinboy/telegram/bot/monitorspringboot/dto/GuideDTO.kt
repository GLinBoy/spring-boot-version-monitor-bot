package com.glinboy.telegram.bot.monitorspringboot.dto

sealed class GuideDTO {
    class HomeArrayValue(val value: List<HomeDTO>) : GuideDTO()
    class HomeValue(val value: HomeDTO) : GuideDTO()
}
