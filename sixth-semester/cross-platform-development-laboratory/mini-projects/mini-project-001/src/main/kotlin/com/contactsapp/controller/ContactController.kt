package com.contactsapp.controller

import com.contactsapp.model.Contact
import com.contactsapp.service.ContactService
import org.springframework.http.HttpStatus
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.*

@RestController
@RequestMapping("/contacts")
class ContactController(private val contactService: ContactService) {
    @GetMapping
    fun getContacts(): ResponseEntity<List<Contact>> {
        val contacts = contactService.getAll()

        return if (contacts.isNotEmpty()) {
            ResponseEntity.ok(contacts)
        } else {
            ResponseEntity.noContent().build()
        }
    }

    @GetMapping("/{id}")
    fun getContact(@PathVariable id: String): ResponseEntity<Contact> {
        val contact = contactService.getById(id)

        return if (contact != null) {
            ResponseEntity.ok(contact)
        } else {
            ResponseEntity.notFound().build()
        }
    }

    @PostMapping
    fun createContact(@RequestBody contact: Contact): ResponseEntity<Contact> {
        val createdContact = contactService.create(contact)

        return ResponseEntity.status(HttpStatus.CREATED).body(createdContact)
    }

    @DeleteMapping("/{id}")
    fun deleteContact(@PathVariable id: String): ResponseEntity<Void> {
        val wasRemoved = contactService.delete(id)

        return if (wasRemoved) {
            ResponseEntity.noContent().build()
        } else {
            ResponseEntity.notFound().build()
        }
    }
}
