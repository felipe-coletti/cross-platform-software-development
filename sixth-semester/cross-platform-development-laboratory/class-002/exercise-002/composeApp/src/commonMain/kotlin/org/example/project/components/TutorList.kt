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
import org.example.project.components.TutorListItem

@Composable
fun TutorList(tutors: List<Tutor>) {
    if (tutors.isEmpty()) {
        Text("Nenhum tutor cadastrado ainda.")
        return
    }

    LazyColumn(modifier = listColumnStyle.modifier) {
        items(tutors) { tutor ->
            TutorListItem(tutor)
        }
    }
}
