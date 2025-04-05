package org.example.project.viewmodel

import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import org.example.project.models.Tutor

class TutorViewModel {
    var tutors by mutableStateOf(listOf<Tutor>())
        private set

    var name by mutableStateOf("")
    var phone by mutableStateOf("")
    var document by mutableStateOf("")

    fun addTutor() {
        if (name.isBlank() || phone.isBlank() || document.isBlank()) return

        val tutor = Tutor(
            name = name,
            phone = phone,
            document = document
        )
        
        tutors = tutors + tutor

        name = ""
        phone = ""
        document = ""
    }
}
