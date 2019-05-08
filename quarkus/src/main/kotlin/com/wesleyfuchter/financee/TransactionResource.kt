package com.wesleyfuchter.financee

import javax.inject.Inject
import javax.ws.rs.Consumes
import javax.ws.rs.POST
import javax.ws.rs.Path
import javax.ws.rs.Produces
import javax.ws.rs.core.MediaType
import javax.ws.rs.core.Response

@Path("/transaction")
@Produces(MediaType.APPLICATION_JSON)
@Consumes(MediaType.APPLICATION_JSON)
class TransactionResource @Inject constructor(private val accountController: AccountController,
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

}