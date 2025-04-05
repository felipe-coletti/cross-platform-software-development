package org.example.project

import androidx.compose.foundation.layout.Column
import androidx.compose.material.Button
import androidx.compose.material.Text
import androidx.compose.material.TextField
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Modifier

val name = mutableStateOf("")
val phone : MutableState<String> = mutableStateOf("")
val email : MutableState<String> = mutableStateOf("")
val list : MutableState<List<Contact>> = mutableStateOf( listOf() )

fun createContact() { 
    val contact = Contact( name.value, phone.value, email.value )
    val newList : MutableList<Contact> = mutableListOf()

    newList.addAll( list.value )
    newList.add( contact )
    list.value = newList.toList()
    
    println("Lista possui ${list.value.size} elementos")
    println(list.value)
}

@Composable
fun Form() { 
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