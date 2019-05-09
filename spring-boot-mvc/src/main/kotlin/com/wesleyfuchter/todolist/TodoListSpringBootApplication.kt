package com.wesleyfuchter.todolist

import org.springframework.boot.autoconfigure.SpringBootApplication
import org.springframework.boot.runApplication

@SpringBootApplication
class TodoListSpringBootApplication

fun main(args: Array<String>) {
	runApplication<TodoListSpringBootApplication>(*args)
}
