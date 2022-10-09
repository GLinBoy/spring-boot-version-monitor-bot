package com.glinboy.telegram.bot.monitorspringboot.service.impl

import com.glinboy.telegram.bot.monitorspringboot.dto.event.NewVersionEvent
import com.glinboy.telegram.bot.monitorspringboot.entity.LatestVersion
import com.glinboy.telegram.bot.monitorspringboot.repository.LatestVersionRepository
import com.glinboy.telegram.bot.monitorspringboot.service.LatestVersionService
import org.slf4j.LoggerFactory
import org.springframework.context.event.EventListener
import org.springframework.core.annotation.Order
import org.springframework.stereotype.Service
import org.springframework.transaction.annotation.Transactional

@Service
@Transactional(readOnly = true)
class LatestVersionServiceImpl(
    val repository: LatestVersionRepository
) : LatestVersionService {

    private val log = LoggerFactory.getLogger(this::class.java)

    override fun isLatestVersion(v: String): Boolean = !repository.existsById(v)

    @Transactional
    @Order(1000)
    @EventListener(NewVersionEvent::class)
    override fun updateVersion(v: NewVersionEvent) {
        repository.deleteAllByVersionStartsWith(v.version.substring(0, v.version.lastIndexOf('.')))
        repository.save(LatestVersion(v.version))
    }
}
