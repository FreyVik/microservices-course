package com.freyvik.agenda.controller;

import com.freyvik.agenda.entity.ContactEntity;
import com.freyvik.agenda.model.Contact;
import com.freyvik.agenda.service.AgendaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class ContactController {
    @Autowired
    AgendaService service;

    @GetMapping(value = "contacts", produces = MediaType.APPLICATION_JSON_VALUE)
    public List<ContactEntity> getContacts() {
        return service.getContacts();
    }

    @GetMapping(value = "contacts/{id}", produces = MediaType.APPLICATION_JSON_VALUE)
    public ContactEntity getContact(@PathVariable("id") Long id) {
        return service.findContact(id);
    }

    @PostMapping(value = "contacts", consumes = MediaType.APPLICATION_JSON_VALUE)
    public String saveContact(@RequestBody ContactEntity contact) {
        return String.valueOf(service.addContact(contact));
    }

    @PutMapping(value = "contacts/update", consumes = MediaType.APPLICATION_JSON_VALUE)
    public void updateContact(@RequestBody ContactEntity contact) {
        service.updateContact(contact);
    }

    @DeleteMapping(value = "contacts/delete/{id}")
    public void deleteContact(@PathVariable("id") Long idContact) {
        service.deleteContact(idContact);
    }
}
