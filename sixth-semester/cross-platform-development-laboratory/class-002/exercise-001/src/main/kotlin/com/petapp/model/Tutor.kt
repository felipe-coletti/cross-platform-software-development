package com.petapp.model

import java.util.UUID
import jakarta.validation.constraints.*
import java.time.LocalDate

data class Tutor(
    val id: String = UUID.randomUUID().toString(),
    @field:NotEmpty(message = "Name cannot be empty")
    @field:Size(min = 5, max = 50, message = "Name must be between 5 and 50 characters")
    val name: String,
    
    @field:NotEmpty(message = "Document cannot be empty")
    @field:Pattern(
        regexp = "\\d{3}\\.\\d{3}\\.\\d{3}\\-\\d{2}",
        message = "Document must follow the pattern XXX.XXX.XXX-XX"
    )
    val document: String
)

