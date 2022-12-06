package com.glinboy.telegram.bot.monitorspringboot.entity

import jakarta.persistence.Entity
import jakarta.persistence.Id

@Entity
data class LatestVersion(
    @Id val version: String? = null
)
