package com.petapp.repository

import com.petapp.model.Pet
import org.springframework.data.jpa.repository.JpaRepository
import org.springframework.stereotype.Repository

@Repository
interface PetRepository : JpaRepository<Pet, String> {}
