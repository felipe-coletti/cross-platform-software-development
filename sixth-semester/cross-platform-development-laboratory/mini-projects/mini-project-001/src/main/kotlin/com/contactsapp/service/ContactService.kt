package com.contactsapp.service

import org.springframework.stereotype.Service
import com.contactsapp.model.Contact
import com.contactsapp.repository.ContactRepository

@Service
class ContactService(private val contactRepository: ContactRepository) {
    fun getAll(): List<Contact> {
        return contactRepository.findAll()
    }

    fun getById(id: String): Contact? {
        return contactRepository.findById(id).orElse(null)
    }

    fun create(contact: Contact): Contact {
        return contactRepository.save(contact)
    }

    fun update(id: String, updatedContact: Contact): Contact? {
        val existingContact = contactRepository.findById(id).orElse(null)

        return if (existingContact != null) {
            val updated = existingContact.copy(
                name = updatedContact.name,
                email = updatedContact.email,
                phone = updatedContact.phone
            )
            
            contactRepository.save(updated)
        } else {
            null
        }
    }

    fun delete(id: String): Boolean {
        return if (contactRepository.existsById(id)) {
            contactRepository.deleteById(id)
            true
        } else {
            false
        }
    }
}