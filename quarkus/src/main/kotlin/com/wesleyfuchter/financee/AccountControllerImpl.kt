package com.wesleyfuchter.financee

import javax.enterprise.context.ApplicationScoped

@ApplicationScoped
open class AccountControllerImpl: AccountController {

    override fun add(account: Account, value: Double): Transaction {
        val transaction = Transaction(account, TransactionType.CREDIT, value)
        println("Transaction add successfully created with the value ${transaction.value}")
        return transaction
    }

    override fun minus(account: Account, value: Double): Transaction {
        val transaction = Transaction(account, TransactionType.DEBIT, value)
        println("Transaction minus successfully created with the value ${transaction.value}")
        return transaction
    }

}