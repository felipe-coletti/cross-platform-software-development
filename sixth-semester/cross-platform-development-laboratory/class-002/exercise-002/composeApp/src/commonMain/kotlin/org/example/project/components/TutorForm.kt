package org.example.project.components

import androidx.compose.material.*
import androidx.compose.runtime.*
import androidx.compose.foundation.layout.*
import org.example.project.models.Tutor
import org.example.project.styles.ColumnStyle
import org.example.project.styles.formColumnStyle

val tutors = mutableStateOf(listOf<Tutor>())
val tutorName = mutableStateOf("")
val tutorPhone = mutableStateOf("")
val tutorDocument = mutableStateOf("")

@Composable
fun TutorForm() {
    Column(modifier = formColumnStyle.modifier) {
        TextField(value = tutorName.value, onValueChange = { tutorName.value = it }, label = { Text("Nome") })
        TextField(value = tutorPhone.value, onValueChange = { tutorPhone.value = it }, label = { Text("Telefone") })
        TextField(value = tutorDocument.value, onValueChange = { tutorDocument.value = it }, label = { Text("Documento") })
        Button(onClick = {
            val newTutor = Tutor(tutorName.value, tutorPhone.value, tutorDocument.value)
            
            tutors.value = tutors.value + newTutor
            
            tutorName.value = ""
            tutorPhone.value = ""
            tutorDocument.value = ""
        }) {
            Text("Adicionar")
        }
    }
}
