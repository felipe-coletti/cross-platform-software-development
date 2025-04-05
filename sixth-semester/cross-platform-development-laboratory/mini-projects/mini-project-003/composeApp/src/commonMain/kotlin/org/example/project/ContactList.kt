package org.example.project

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp

@Composable
fun ContactList() {
    LazyColumn( modifier = listColumnStyle.modifier ) {
        items(list.value) { contact ->  
            Column (modifier = Modifier.padding(10.dp)) {
                Text(contact.nome)
                Text(contact.phone)
                Text(contact.email)
            }
        }
    }
}