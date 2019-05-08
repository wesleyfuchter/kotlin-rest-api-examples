package com.wesleyfuchter.financee

data class Transaction (val account: Account,
                        val type: TransactionType,
                        val value: Double)