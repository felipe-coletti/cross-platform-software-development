package org.example.project.components

import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import org.example.project.styles.listColumnStyle
import org.example.project.styles.cardColumnStyle
import org.example.project.models.Pet

@Composable
fun PetList(pets: List<Pet>) {
    if (pets.isEmpty()) {
        Text("Nenhum pet cadastrado ainda.")
        return
    }

    LazyColumn(modifier = listColumnStyle.modifier) {
        items(pets) { pet ->
            PetListItem(pet)
        }
    }
}

@Composable
fun PetListItem(pet: Pet) {
    Column(modifier = cardColumnStyle.modifier) {
        Text("Nome: ${pet.name}")
        Text("Raça: ${pet.breed}")
        Text("Peso: ${pet.weight} kg")
        Text("Nascimento: ${pet.birthDate}")
        Text("Tutor: ${pet.tutor}")
    }
}
