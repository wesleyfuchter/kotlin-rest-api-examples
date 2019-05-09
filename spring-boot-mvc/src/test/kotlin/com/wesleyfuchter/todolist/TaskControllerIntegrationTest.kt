package com.wesleyfuchter.todolist

import junit.framework.Assert.assertEquals
import junit.framework.Assert.assertNotNull
import org.junit.Test
import org.junit.runner.RunWith
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.boot.test.context.SpringBootTest
import org.springframework.boot.test.web.client.TestRestTemplate
import org.springframework.boot.test.web.client.postForEntity
import org.springframework.http.HttpStatus
import org.springframework.test.context.junit4.SpringRunner

@RunWith(SpringRunner::class)
@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
class TaskControllerIntegrationTest {

    @Autowired
    private lateinit var template: TestRestTemplate

    @Test
    fun `test should return the list of tasks`() {
        val result = template.getForEntity("/tasks", ArrayList::class.java)
        assertNotNull(result)
        assertEquals(result.statusCode, HttpStatus.OK)
        assertEquals(listOf(
                mapOf(Pair("description", "Task 1"), Pair("done", false)),
                mapOf(Pair("description", "Task 2"), Pair("done", true))
        ), result.body)
    }

    @Test
    fun `test should persist a task and return the same content`() {
        val result = template.postForEntity<Map<String, Any>>("/tasks",
                mapOf(Pair("description", "Task 3"), Pair("done", false)))
        assertNotNull(result)
        assertEquals(result.statusCode, HttpStatus.OK)
        assertEquals(mapOf(Pair("description", "Task 3"), Pair("done", false)), result.body)
    }

}
