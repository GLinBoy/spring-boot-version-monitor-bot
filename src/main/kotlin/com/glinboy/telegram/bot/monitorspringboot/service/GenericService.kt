package com.glinboy.telegram.bot.monitorspringboot.service

import org.springframework.data.domain.Page
import org.springframework.data.domain.Pageable

interface GenericService<T, ID> {
    fun save(t: T): T
    fun saveAll(t: Iterable<T>): List<T>
    fun update(t: T): T
    fun findById(id: ID): T?
    fun count(): Long
    fun getAll(pageable: Pageable): Page<T>
    fun deleteById(id: ID)
    fun deleteByReference(t: T)
}
