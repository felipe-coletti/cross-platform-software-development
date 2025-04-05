package org.example.project.components

import androidx.compose.foundation.layout.Column
import androidx.compose.material.*
import androidx.compose.runtime.Composable
import androidx.lifecycle.viewmodel.compose.viewModel
import org.example.project.styles.ColumnStyle
import org.example.project.viewmodel.PetViewModel
import org.example.project.ui.components.DateTextField

@Composable
fun PetForm(viewModel: PetViewModel = viewModel()) {
    Column(
        modifier = formColumnStyle.modifier,
    ) {
        TextField(value = viewModel.name, onValueChange = { viewModel.name = it }, label = { Text("Nome do Pet") })
        TextField(value = viewModel.breed, onValueChange = { viewModel.breed = it }, label = { Text("Raça") })
        TextField(value = viewModel.weight, onValueChange = { viewModel.weight = it }, label = { Text("Peso (kg)") })
        DateTextField(viewModel.birthDate)
        TextField(value = viewModel.tutor, onValueChange = { viewModel.tutor = it }, label = { Text("Nome do Tutor") })
        Button(onClick = { viewModel.addPet() }) {
            Text("Adicionar")
        }
    }
}

