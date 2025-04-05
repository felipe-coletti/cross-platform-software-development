package com.petapp.controller

import com.petapp.model.Tutor
import com.petapp.service.TutorService
import org.springframework.http.HttpStatus
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.*

@RestController
@RequestMapping("/tutors")
class TutorController(private val tutorService: TutorService) {
    @GetMapping
    fun getTutors(): ResponseEntity<List<Tutor>> {
        val tutors = tutorService.getAll()

        return if (tutors.isNotEmpty()) {
            ResponseEntity.ok(tutors)
        } else {
            ResponseEntity.noContent().build()
        }
    }

    @GetMapping("/{id}")
    fun getTutor(@PathVariable id: String): ResponseEntity<Tutor> {
        val tutor = tutorService.getById(id)

        return if (tutor != null) {
            ResponseEntity.ok(tutor)
        } else {
            ResponseEntity.notFound().build()
        }
    }

    @PostMapping
    fun createTutor(@RequestBody tutor: Tutor): ResponseEntity<Tutor> {
        val createdTutor = tutorService.create(tutor)

        return ResponseEntity.status(HttpStatus.CREATED).body(createdTutor)
    }

    @PutMapping("/{id}")
    fun updateTutor(@PathVariable id: String, @RequestBody updatedTutor: Tutor): ResponseEntity<Tutor> {
        val wasUpdated = tutorService.update(id, updatedTutor)

        return if (wasUpdated != null) {
            ResponseEntity.ok(wasUpdated)
        } else {
            ResponseEntity.notFound().build()
        }
    }

    @DeleteMapping("/{id}")
    fun deleteTutor(@PathVariable id: String): ResponseEntity<Void> {
        val wasRemoved = tutorService.delete(id)

        return if (wasRemoved) {
            ResponseEntity.noContent().build()
        } else {
            ResponseEntity.notFound().build()
        }
    }
}
