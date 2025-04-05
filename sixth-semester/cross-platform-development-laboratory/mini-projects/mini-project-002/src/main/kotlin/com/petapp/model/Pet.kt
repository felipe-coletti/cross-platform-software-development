package com.petapp.model

import java.util.UUID
import java.time.LocalDate

data class Pet(
    val id: String = UUID.randomUUID().toString(),
    val name: String,
    val breed: String,
    val weight: Double,
    val birthDate: LocalDate,
    val tutorId: String
)
