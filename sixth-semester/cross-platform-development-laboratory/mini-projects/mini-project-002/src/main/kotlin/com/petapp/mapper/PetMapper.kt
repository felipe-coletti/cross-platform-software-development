package com.petapp.mapper

import com.contactsapp.dto.PetDTO
import com.contactsapp.model.Pet
import jakarta.validation.Validation
import org.springframework.stereotype.Component

@Component
class PetMapper {
    fun toDTO(pet: Pet): PetDTO {
        return PetDTO(
            id = pet.id,
            name = pet.name,
            breed = pet.breed,
            weight = pet.weight,
            birthdateDate = pet.birthdateDate,
            tutorId = pet.tutorId
        )
    }

    fun fromDTO(petDTO: PetDTO): Pet {
        val validator = Validation.buildDefaultValidatorFactory().validator
        val violations = validator.validate(petDTO)
        
        if (violations.isNotEmpty()) {
            throw IllegalArgumentException("Invalid PetDTO: ${violations.joinToString(", ") { it.message }}")
        }
        
        return Pet(
            id = petDTO.id ?: UUID.randomUUID().toString(),
            name = petDTO.name,
            breed = petDTO.breed,
            weight = petDTO.weight,
            birthdate = petDTO.birthdate,
            tutor = petDTO.tutor
        )
    }
}

