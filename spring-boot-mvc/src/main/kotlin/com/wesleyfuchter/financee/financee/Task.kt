package com.wesleyfuchter.financee.financee

import java.util.*
import javax.persistence.Column
import javax.persistence.Entity
import javax.persistence.GeneratedValue
import javax.persistence.Id

@Entity
data class Task(

        @Id
        @GeneratedValue
        private val id: UUID?,

        @Column
        private val description: String,

        @Column
        private val done: Boolean

)