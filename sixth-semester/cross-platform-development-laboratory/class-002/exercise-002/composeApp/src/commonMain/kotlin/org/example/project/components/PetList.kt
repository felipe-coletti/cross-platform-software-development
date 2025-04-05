package org.example.project.components

import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.*
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import org.example.project.styles.listColumnStyle
import org.example.project.styles.cardColumnStyle
import org.example.project.viewmodel.PetViewModel
import org.example.project.models.Pet
import java.text.DecimalFormat

@Composable
fun PetList(viewModel: PetViewModel) {
    val pets by viewModel.petList.collectAsState()

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
