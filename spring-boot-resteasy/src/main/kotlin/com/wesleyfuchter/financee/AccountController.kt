package com.wesleyfuchter.financee

interface AccountController {

    fun add(account: Account, value: Double): Transaction

    fun minus(account: Account, value: Double): Transaction

}