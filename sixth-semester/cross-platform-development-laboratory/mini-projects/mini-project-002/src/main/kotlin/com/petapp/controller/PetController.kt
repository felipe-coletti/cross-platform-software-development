package com.petapp.controller

import com.petapp.dto.PetDTO
import com.petapp.mapper.PetMapper
import com.petapp.service.PetService
import org.springframework.http.HttpStatus
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.*

@RestController
@RequestMapping("/pets")
class PetController(
    private val petService: PetService,
    private val petMapper: PetMapper
) {
    @GetMapping
    fun getPets(): ResponseEntity<List<PetDTO>> {
        val pets = petService.getAll().map { petMapper.toDTO(it) }

        return if (pets.isNotEmpty()) {
            ResponseEntity.ok(pets)
        } else {
            ResponseEntity.noContent().build()
        }
    }

    @GetMapping("/{id}")
    fun getPet(@PathVariable id: String): ResponseEntity<PetDTO> {
        val pet = petService.getById(id)

        return if (pet != null) {
            ResponseEntity.ok(petMapper.toDTO(pet))
        } else {
            ResponseEntity.notFound().build()
        }
    }

    @PostMapping
    fun createPet(@RequestBody petDTO: PetDTO): ResponseEntity<PetDTO> {
        val pet = petMapper.fromDTO(petDTO)
        val createdPet = petService.create(pet)

        return ResponseEntity.status(HttpStatus.CREATED).body(petMapper.toDTO(createdPet))
    }

    @PutMapping("/{id}")
    fun updatePet(@PathVariable id: String, @RequestBody updatedPetDTO: PetDTO): ResponseEntity<PetDTO> {
        val updatedPet = petService.update(id, petMapper.fromDTO(updatedPetDTO))

        return if (updatedPet != null) {
            ResponseEntity.ok(petMapper.toDTO(updatedPet))
        } else {
            ResponseEntity.notFound().build()
        }
    }

    @DeleteMapping("/{id}")
    fun deletePet(@PathVariable id: String): ResponseEntity<Void> {
        val wasRemoved = petService.delete(id)

        return if (wasRemoved) {
            ResponseEntity.noContent().build()
        } else {
            ResponseEntity.notFound().build()
        }
    }
}