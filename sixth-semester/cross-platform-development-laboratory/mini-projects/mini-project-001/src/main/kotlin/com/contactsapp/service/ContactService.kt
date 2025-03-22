package com.contactsapp.service

import org.springframework.stereotype.Service
import com.contactsapp.model.Contact
import com.contactsapp.repository.ContactRepository

@Service
class ContactService(private val contactRepository: ContactRepository) {
    fun getAllContacts(): List<Contact> {
        return contactRepository.findAll()
    }

    fun getContactById(id: String): Contact? {
        return contactRepository.findById(id).orElse(null)
    }

    fun createContact(contact: Contact): Contact {
        return contactRepository.save(contact)
    }

    fun deleteContact(id: String): Boolean {
        return if (contactRepository.existsById(id)) {
            contactRepository.deleteById(id)
            true
        } else {
            false
        }
    }
}