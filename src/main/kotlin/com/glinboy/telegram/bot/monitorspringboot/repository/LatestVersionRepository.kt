package com.glinboy.telegram.bot.monitorspringboot.repository

import com.glinboy.telegram.bot.monitorspringboot.entity.LatestVersion
import org.springframework.data.jpa.repository.JpaRepository

interface LatestVersionRepository: JpaRepository<LatestVersion, String> {
}
