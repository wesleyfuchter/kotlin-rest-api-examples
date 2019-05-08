package com.wesleyfuchter.financee.financee

import org.springframework.beans.factory.annotation.Autowired
import org.springframework.http.ResponseEntity
import org.springframework.stereotype.Controller
import org.springframework.web.bind.annotation.*

@Controller
@RequestMapping("/tasks")
class TaskController @Autowired constructor(val tasks: Tasks) {

    @PostMapping
    fun create(@RequestBody task: Task): ResponseEntity<Task> {
        return ResponseEntity.ok().body(tasks.save(task))
    }

    @GetMapping
    fun findAll(): ResponseEntity<Iterable<Task>> {
        return ResponseEntity.ok().body(tasks.findAll())
    }

    @GetMapping("/search")
    fun findByDescription(@PathVariable description: String): ResponseEntity<List<Task>> {
        return ResponseEntity.ok().body(tasks.findByDescription(description))
    }

}