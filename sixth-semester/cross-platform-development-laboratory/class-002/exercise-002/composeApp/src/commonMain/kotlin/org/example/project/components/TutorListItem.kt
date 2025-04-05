package org.example.project.components

import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.*
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import org.example.project.components.TutorForm
import org.example.project.styles.listColumnStyle
import org.example.project.styles.cardColumnStyle
import org.example.project.models.Tutor

@Composable
fun TutorListItem(tutor: Tutor) {
    Column(
        modifier = cardColumnStyle.modifier,
        verticalArrangement = cardColumnStyle.verticalArrangement
    ) {
        Text("Nome: ${tutor.name}")
        Text("Telefone: ${tutor.phone}")
        Text("Documento: ${tutor.document}")
    }
}