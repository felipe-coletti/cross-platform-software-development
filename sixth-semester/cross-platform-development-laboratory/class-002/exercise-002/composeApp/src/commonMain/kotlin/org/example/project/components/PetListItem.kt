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
fun PetListItem(pet: Pet) {
    Column(
        modifier = cardColumnStyle.modifier,
        verticalArrangement = cardColumnStyle.verticalArrangement
    ) {
        Text("Nome: ${pet.name}")
        Text("Raça: ${pet.breed}")
        Text("Peso: ${pet.weight} kg")
        Text("Nascimento: ${pet.birthDate}")
        Text("Tutor: ${pet.tutor}")
    }
}