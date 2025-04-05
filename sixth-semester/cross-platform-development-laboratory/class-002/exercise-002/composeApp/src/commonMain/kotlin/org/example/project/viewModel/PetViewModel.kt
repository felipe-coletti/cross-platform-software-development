package org.example.project.viewmodel

import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import org.example.project.models.Pet

class PetViewModel {
    var pets by mutableStateOf(listOf<Pet>())
        private set

    var name by mutableStateOf("")
    var breed by mutableStateOf("")
    var weight by mutableStateOf("")
    var birthDate by mutableStateOf("")
    var tutor by mutableStateOf("")

    fun addPet() {
        val weightValue = weight.toDoubleOrNull() ?: return
        if (name.isBlank() || breed.isBlank() || tutor.isBlank() || birthDate.length != 10) return

        val pet = Pet(
            name = name,
            breed = breed,
            weight = weightValue,
            birthDate = birthDate,
            tutor = tutor
        )
        pets = pets + pet

        // Limpa os campos
        name = ""
        breed = ""
        weight = ""
        birthDate = ""
        tutor = ""
    }
}
