package org.example.project

import androidx.compose.foundation.layout.*
import androidx.compose.material.*
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import org.example.project.styles.mainColumnStyle
import org.example.project.models.Contact
import org.jetbrains.compose.ui.tooling.preview.Preview
import org.example.project.components.ContactList
import org.example.project.components.Form
import org.example.project.components.Header

@Composable
@Preview
fun App() {
    val list = remember { mutableStateOf(listOf<Contact>()) }

    MaterialTheme {
        Column( modifier = mainColumnStyle.modifier ) {
            Header()
            Spacer(modifier = Modifier.height(16.dp))
            Form(list = list)
            Spacer(modifier = Modifier.height(16.dp))
            ContactList(list = list.value)
        }
    }
}
