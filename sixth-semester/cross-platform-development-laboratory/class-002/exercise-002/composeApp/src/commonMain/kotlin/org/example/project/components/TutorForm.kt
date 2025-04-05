package org.example.project.components

import androidx.compose.material.*
import androidx.compose.runtime.*
import androidx.compose.foundation.layout.*
import org.example.project.models.Tutor
import org.example.project.styles.ColumnStyle
import org.example.project.styles.formColumnStyle
import org.example.project.viewmodel.TutorViewModel

@Composable
fun TutorForm(viewModel: TutorViewModel) {
    Column(
        modifier = formColumnStyle.modifier,
        horizontalAlignment = formColumnStyle.horizontalAlignment,
        verticalArrangement = formColumnStyle.verticalArrangement
    ) {
        TextField(value = viewModel.name, onValueChange = { viewModel.name = it }, label = { Text("Nome") })
        TextField(value = viewModel.phone, onValueChange = { viewModel.phone = it }, label = { Text("Telefone") })
        TextField(value = viewModel.document, onValueChange = { viewModel.document = it }, label = { Text("Documento") })
        Button(onClick = { viewModel.addTutor() }) {
            Text("Adicionar")
        }
    }
}
