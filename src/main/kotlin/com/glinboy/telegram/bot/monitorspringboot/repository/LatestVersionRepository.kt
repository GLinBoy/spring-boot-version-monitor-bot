package com.glinboy.telegram.bot.monitorspringboot.repository

import com.glinboy.telegram.bot.monitorspringboot.entity.LatestVersion
import org.springframework.data.jpa.repository.JpaRepository
import org.springframework.data.jpa.repository.Modifying

interface LatestVersionRepository: JpaRepository<LatestVersion, String> {

    @Modifying
    fun deleteAllByVersionStartsWith(version: String)
}
