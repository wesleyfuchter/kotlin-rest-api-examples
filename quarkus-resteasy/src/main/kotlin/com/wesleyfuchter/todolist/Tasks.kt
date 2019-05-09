package com.wesleyfuchter.todolist

interface Tasks {

    fun save(task: Task): Task

    fun findAll(): List<Task>

}