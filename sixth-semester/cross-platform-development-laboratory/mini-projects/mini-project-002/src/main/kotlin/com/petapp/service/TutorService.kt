package com.petapp.service

import org.springframework.stereotype.Service
import com.petapp.model.Tutor
import com.petapp.repository.TutorRepository

@Service
class TutorService(private val tutorRepository: TutorRepository) {
    fun getAll(): List<Tutor> {
        return tutorRepository.findAll()
    }

    fun getById(id: String): Tutor? {
        return tutorRepository.findById(id).orElse(null)
    }

    fun create(tutor: Tutor): Tutor {
        return tutorRepository.save(tutor)
    }

    fun update(id: String, updatedTutor: Tutor): Tutor? {
        val existingTutor = tutorRepository.findById(id).orElse(null)

        return if (existingTutor != null) {
            val updated = existingTutor.copy(
                name = updatedTutor.name,
                breed = updatedTutor.breed,
                weight = updatedTutor.weight,
                birthDate = updatedTutor.birthDate,
                tutorId = updatedTutor.tutorId,
            )
            
            tutorRepository.save(updated)
        } else {
            null
        }
    }

    fun delete(id: String): Boolean {
        return if (tutorRepository.existsById(id)) {
            tutorRepository.deleteById(id)
            true
        } else {
            false
        }
    }
}