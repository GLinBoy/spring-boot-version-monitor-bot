package com.glinboy.telegram.bot.monitorspringboot.service.impl

import com.glinboy.telegram.bot.monitorspringboot.service.GenericService
import org.springframework.data.domain.Page
import org.springframework.data.domain.Pageable
import org.springframework.data.jpa.repository.JpaRepository

abstract class GenericServiceImpl<T : Any, ID : Any, R : JpaRepository<T, ID>>(
    private val repository: R
) : GenericService<T, ID> {

    override fun save(t: T): T = repository.save(t)

    override fun saveAll(ts: Iterable<T>): List<T> = repository.saveAll(ts)

    override fun update(t: T): T = this.save(t)

    override fun findById(id: ID): T? = repository.findById(id).orElse(null)

    override fun count(): Long = repository.count()

    override fun getAll(pageable: Pageable): Page<T> = repository.findAll(pageable)

    override fun deleteById(id: ID) = repository.deleteById(id)

    override fun deleteByReference(t: T) = repository.delete(t)
}
