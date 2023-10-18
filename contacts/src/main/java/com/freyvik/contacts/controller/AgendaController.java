package com.freyvik.contacts.controller;

import com.freyvik.contacts.model.Contact;
import com.freyvik.contacts.service.AgendaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class AgendaController {

    @Autowired
    AgendaService agendaService;

    @GetMapping(value = "contacts", produces = MediaType.APPLICATION_JSON_VALUE)
    public List<Contact> getContacts() {
        return agendaService.getAllContacts();
    }

    @GetMapping(value = "contact/{id}", produces = MediaType.APPLICATION_JSON_VALUE)
    public Contact getContact(@PathVariable("id") int id) {
        return agendaService.getContact(id);
    }

    @PostMapping(value = "contact",consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
    public String saveContact(@RequestBody Contact contact) {
        return String.valueOf(agendaService.addContact(contact));
    }

    @PutMapping(value = "contact",consumes = MediaType.APPLICATION_JSON_VALUE)
    public void updateContact(@RequestBody Contact contact) {
        agendaService.updateContact(contact);
    }

    @DeleteMapping(value = "contact/{id}")
    public void deleteContact(@PathVariable("id") int idContact) {
        agendaService.deleteContact(idContact);
    }
}
