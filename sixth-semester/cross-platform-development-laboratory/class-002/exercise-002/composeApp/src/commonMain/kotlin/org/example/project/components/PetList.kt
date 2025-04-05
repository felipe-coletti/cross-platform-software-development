package org.example.project.components

import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.*
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp

@Composable
fun PetList() {
    LazyColumn(modifier = listColumnStyle.modifier) {
        items(pets.value) { pet ->
            Column(modifier = cardColumnStyle.modifier) {
                Text("Nome: ${pet.name}")
                Text("Raça: ${pet.breed}")
                Text("Peso: ${"%.2f".format(pet.peso)} kg")
                Text("Nascimento: ${pet.birthDate}")
                Text("Tutor: ${pet.tutor}")
            }
        }
    }
}
