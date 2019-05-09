package com.wesleyfuchter.todolist

import javax.enterprise.context.SessionScoped

@SessionScoped
open class TasksImpl: Tasks {

    override fun save(task: Task): Task {
        println("saving task ${task.description}")
        return task
    }

    override fun findAll(): List<Task> {
        println("returning tasks")
        return listOf(Task("Task 1", false), Task("Task 2", true))
    }

}