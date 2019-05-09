package org.acme.rest

import io.quarkus.test.junit.QuarkusTest
    import io.restassured.RestAssured.given
import org.hamcrest.CoreMatchers.`is`
import org.junit.jupiter.api.Test

@QuarkusTest
open class TaskResourceIntegrationTest {

    @Test
    fun `test should return the list of tasks`() {
        given().`when`().get("/tasks")
                .then()
                .statusCode(200)
                .body(`is`(listOf(
                        mapOf(Pair("description", "Task 1"), Pair("done", false)),
                        mapOf(Pair("description", "Task 2"), Pair("done", true))
                )))
    }

    @Test
    fun `test should persist a task and return the same content`() {
        given().`when`().post("/tasks", mapOf(Pair("description", "Task 3"), Pair("done", false)))
                .then()
                .statusCode(200)
                .body(`is`(mapOf(Pair("description", "Task 3"), Pair("done", false))))
    }

}