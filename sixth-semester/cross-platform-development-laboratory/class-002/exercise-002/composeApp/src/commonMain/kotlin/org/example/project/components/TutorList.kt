package org.example.project.components

import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.*
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp

@Composable
fun TutorList() {
    LazyColumn(modifier = listColumnStyle.modifier) {
        items(tutores.value) { tutor ->
            Column(modifier = cardColumnStyle.modifier) {
                Text("Nome: ${tutor.name}")
                Text("Telefone: ${tutor.phone}")
                Text("Documento: ${tutor.document}")
            }
        }
    }
}
