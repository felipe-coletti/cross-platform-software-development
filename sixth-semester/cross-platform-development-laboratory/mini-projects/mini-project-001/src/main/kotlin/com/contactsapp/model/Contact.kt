package com.contactsapp.model
import java.util.UUID

data class Contact(
    val id: String = UUID.randomUUID().toString(),
    val name: String,
    val email: String,
    val phone: String
)
