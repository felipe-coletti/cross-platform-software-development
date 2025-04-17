package org.example.project.components

import androidx.compose.foundation.layout.Column
import androidx.compose.material.Button
import androidx.compose.material.Text
import androidx.compose.material.TextField
import org.example.project.models.Contact
import androidx.compose.runtime.Composable
import androidx.compose.runtime.remember
import androidx.compose.ui.Modifier
import androidx.compose.runtime.MutableState
import androidx.compose.runtime.mutableStateOf
import org.example.project.styles.formColumnStyle

@Composable
fun Form(list: MutableState<List<Contact>>) {
    val name = remember { mutableStateOf("") }
    val phone = remember { mutableStateOf("") }
    val email = remember { mutableStateOf("") }

    fun createContact() { 
        val newContact = Contact( name.value, phone.value, email.value )
        val newList = list.value.toMutableList()

        newList.add(newContact)
        list.value = newList

        println("Lista possui ${list.value.size} elementos")
        println(list.value)

        name.value = ""
        phone.value = ""
        email.value = ""
    }
    
    Column( modifier = formColumnStyle.modifier ) {
        TextField(
            value = name.value,
            onValueChange = {
                newName -> name.value = newName
            },
            placeholder = { Text("Digite seu nome completo") },
            label = { Text("Nome completo") } 
        )
        TextField(
            value = phone.value,
            onValueChange = { it -> phone.value = it},
            placeholder = { Text("Informe o numero do telefone (dd)XXXX-XXXX") },
            label = { Text("Telefone") } 
        )
        TextField(
            value = email.value,
            onValueChange = {email.value = it},
            placeholder = { Text("Informe um e-mail válido") },
            label = { Text("E-mail") } 
        )
        Button( onClick = { createContact() } ) {
            Text("Adicionar")
        }
    }
}