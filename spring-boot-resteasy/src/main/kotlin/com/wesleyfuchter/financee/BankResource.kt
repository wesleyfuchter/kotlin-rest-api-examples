package com.wesleyfuchter.financee

import org.springframework.stereotype.Component
import javax.inject.Inject
import javax.ws.rs.*
import javax.ws.rs.core.MediaType
import javax.ws.rs.core.Response

@Component
@Path("/bank")
@Produces(MediaType.APPLICATION_JSON)
@Consumes(MediaType.APPLICATION_JSON)
class BankResource @Inject constructor(private val accountController: AccountController,
                                       private val accounts: Accounts) {

    @POST
    @Path("/add")
    fun createAddTransaction(transaction: TransactionDTO): Response {
        val (accountId, value) = transaction
        val accountOptional = accounts.byId(accountId)
        if (accountOptional.isPresent) {
            return Response.ok(accountController.add(accountOptional.get(), value)).build()
        }
        return Response.status(Response.Status.NOT_FOUND).build()
    }

    @GET
    fun hello(): String {
        return "Hello, World"
    }

}