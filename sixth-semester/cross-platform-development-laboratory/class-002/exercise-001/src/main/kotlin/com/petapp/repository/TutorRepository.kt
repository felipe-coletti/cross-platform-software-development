package com.petapp.repository

import com.petapp.model.Tutor
import org.springframework.data.jpa.repository.JpaRepository
import org.springframework.stereotype.Repository

@Repository
interface TutorRepository : JpaRepository<Tutor, String> {}
