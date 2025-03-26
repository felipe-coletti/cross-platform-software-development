package com.contactsapp

import org.springframework.boot.autoconfigure.SpringBootApplication
import org.springframework.boot.runApplication

@SpringBootApplication
class ContactsAppApplication

fun main(args: Array<String>) {
	runApplication<ContactsAppApplication>(*args)
}
