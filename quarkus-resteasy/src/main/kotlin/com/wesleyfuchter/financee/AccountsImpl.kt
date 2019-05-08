package com.wesleyfuchter.financee

import java.util.*
import javax.enterprise.context.ApplicationScoped

@ApplicationScoped
open class AccountsImpl: Accounts {

    override fun byId(id: String): Optional<Account> {
        return Optional.of(Account(id))
    }

}