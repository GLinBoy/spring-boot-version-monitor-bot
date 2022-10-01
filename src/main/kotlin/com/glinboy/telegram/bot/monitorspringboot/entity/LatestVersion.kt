package com.glinboy.telegram.bot.monitorspringboot.entity

import javax.persistence.Entity
import javax.persistence.Id

@Entity
data class LatestVersion(
    @Id val version: String? = null
)
