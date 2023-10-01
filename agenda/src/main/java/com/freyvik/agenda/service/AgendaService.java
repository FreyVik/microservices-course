package com.freyvik.agenda.service;

import com.freyvik.agenda.entity.ContactEntity;
import com.freyvik.agenda.model.Contact;

import java.util.List;

public interface AgendaService {
    boolean addContact(ContactEntity contact);

    List<ContactEntity> getContacts();

    void updateContact(ContactEntity contact);

    boolean deleteContact(Long idContact);

    ContactEntity findContact(Long idContact);
}
