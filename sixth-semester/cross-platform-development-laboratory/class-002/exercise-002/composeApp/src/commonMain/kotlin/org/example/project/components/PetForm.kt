package org.example.project.components

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.*
import androidx.compose.material.*
import androidx.compose.runtime.Composable
import androidx.lifecycle.viewmodel.compose.viewModel
import org.example.project.styles.ColumnStyle
import org.example.project.viewmodel.PetViewModel
import org.example.project.styles.formColumnStyle
import org.example.project.components.DateTextField
import androidx.compose.runtime.*
import androidx.compose.ui.*
import androidx.compose.ui.text.input.*
import androidx.compose.material.*
import androidx.compose.foundation.layout.*
import androidx.compose.ui.unit.dp

@Composable
fun PetForm(viewModel: PetViewModel) {
    val petState by viewModel.petState.collectAsState()

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

