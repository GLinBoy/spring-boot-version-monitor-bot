package com.glinboy.telegram.bot.monitorspringboot.service

import com.glinboy.telegram.bot.monitorspringboot.dto.event.NewVersionEvent

interface LatestVersionService {
    fun isLatestVersion(v: String): Boolean
    fun updateVersion(v: NewVersionEvent)
}
