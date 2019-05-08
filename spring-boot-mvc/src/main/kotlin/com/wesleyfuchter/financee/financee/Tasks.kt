package com.wesleyfuchter.financee.financee

import org.springframework.data.repository.CrudRepository
import org.springframework.stereotype.Repository
import java.util.*

@Repository
interface Tasks: CrudRepository<Task, UUID> {

    fun findByDescription(description: String): List<Task>

}