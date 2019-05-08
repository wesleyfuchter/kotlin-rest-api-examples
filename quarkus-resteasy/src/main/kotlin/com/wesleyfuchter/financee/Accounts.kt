package com.wesleyfuchter.financee

import java.util.*

interface Accounts {

    fun byId(id: String): Optional<Account>

}