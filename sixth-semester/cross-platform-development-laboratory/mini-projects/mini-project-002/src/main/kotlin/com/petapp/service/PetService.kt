package com.petapp.service

import org.springframework.stereotype.Service
import com.petapp.model.Pet
import com.petapp.repository.PetRepository

@Service
class PetService(private val petRepository: PetRepository) {
    fun getAll(): List<Pet> {
        return petRepository.findAll()
    }

    fun getById(id: String): Pet? {
        return petRepository.findById(id).orElse(null)
    }

    fun create(pet: Pet): Pet {
        return petRepository.save(pet)
    }

    fun update(id: String, updatedPet: Pet): Pet? {
        val existingPet = petRepository.findById(id).orElse(null)

        return if (existingPet != null) {
            val updated = existingPet.copy(
                name = updatedPet.name,
                document = updatedPet.document,
            )
            
            petRepository.save(updated)
        } else {
            null
        }
    }

    fun delete(id: String): Boolean {
        return if (petRepository.existsById(id)) {
            petRepository.deleteById(id)
            true
        } else {
            false
        }
    }
}