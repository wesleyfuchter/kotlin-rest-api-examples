package com.wesleyfuchter.todolist

import org.springframework.beans.factory.annotation.Autowired
import org.springframework.http.ResponseEntity
import org.springframework.stereotype.Controller
import org.springframework.web.bind.annotation.*

@Controller
@RequestMapping("/tasks")
class TaskController @Autowired constructor(val tasks: Tasks) {

    @PostMapping
    fun create(@RequestBody task: Task): ResponseEntity<Task> = ResponseEntity.ok().body(tasks.save(task))

    @GetMapping
    fun findAll(): ResponseEntity<List<Task>> = ResponseEntity.ok().body(tasks.findAll())

}