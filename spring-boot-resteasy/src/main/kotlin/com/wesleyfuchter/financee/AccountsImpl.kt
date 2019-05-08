package com.wesleyfuchter.financee

import org.springframework.stereotype.Service
import java.util.*

@Service
class AccountsImpl: Accounts {

    override fun byId(id: String): Optional<Account> {
        return Optional.of(Account(id))
    }

}