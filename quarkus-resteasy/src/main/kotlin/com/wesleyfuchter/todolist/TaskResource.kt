package com.wesleyfuchter.todolist

import javax.inject.Inject
import javax.ws.rs.Consumes
import javax.ws.rs.GET
import javax.ws.rs.POST
import javax.ws.rs.Path
import javax.ws.rs.Produces
import javax.ws.rs.core.MediaType
import javax.ws.rs.core.Response

@Path("/tasks")
@Produces(MediaType.APPLICATION_JSON)
@Consumes(MediaType.APPLICATION_JSON)
class TaskResource {

    @Inject
    private lateinit var tasks: Tasks

    @POST
    fun create(task: Task): Response = Response.ok().entity(tasks.save(task)).build()

    @GET
    fun findAll(): Response = Response.ok().entity(tasks.findAll()).build()

}