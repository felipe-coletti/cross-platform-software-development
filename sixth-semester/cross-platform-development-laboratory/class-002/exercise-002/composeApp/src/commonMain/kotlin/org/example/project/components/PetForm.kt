package org.example.project.components

import androidx.compose.foundation.layout.*
import androidx.compose.material.*
import androidx.compose.runtime.*
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import org.example.project.styles.formColumnStyle
import org.example.project.viewmodel.PetViewModel

@Composable
fun PetForm(viewModel: PetViewModel) {
    Column (
        modifier = formColumnStyle.modifier,
        horizontalAlignment = formColumnStyle.horizontalAlignment,
        verticalArrangement = formColumnStyle.verticalArrangement
    ) {
        TextField(value = viewModel.name, onValueChange = { viewModel.name = it }, label = { Text("Nome") })
        TextField(value = viewModel.breed, onValueChange = { viewModel.breed = it }, label = { Text("Raça") })
        TextField(value = viewModel.weight, onValueChange = { viewModel.weight = it }, label = { Text("Peso") })
        TextField(value = viewModel.birthDate, onValueChange = { viewModel.birthDate = it }, label = { Text("Data de nascimento (DD/MM/AAAA)") })
        TextField(value = viewModel.tutor, onValueChange = { viewModel.tutor = it }, label = { Text("Tutor") })
        Button(onClick = { viewModel.addPet() }) {
            Text("Adicionar")
        }
    }
}
