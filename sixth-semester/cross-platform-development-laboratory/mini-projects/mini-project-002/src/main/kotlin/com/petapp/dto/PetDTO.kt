package com.petapp.dto

import java.util.UUID
import jakarta.validation.constraints.*
import java.time.LocalDate

data class PetDTO(
    val id: String = UUID.randomUUID().toString(),
    
    @field:NotEmpty(message = "Name cannot be empty")
    @field:Size(min = 5, max = 25, message = "Name must be between 5 and 25 characters")
    val name: String,
    
    @field:NotEmpty(message = "Breed cannot be empty")
    val breed: String,
    
    @field:DecimalMin(value = "0.0", message = "Weight must be at least 0.0")
    @field:DecimalMax(value = "400.0", message = "Weight must be at most 400.0")
    val weight: Double,
    
    @field:Past(message = "Birthdate must be in the past")
    val birthdate: LocalDate,
    
    @field:Valid
    val tutor: Tutor
)