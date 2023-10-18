package com.freyvik.contacts.service;

import com.freyvik.contacts.model.Contact;

import java.util.List;

public interface AgendaService {
    boolean addContact(Contact contact);

    List<Contact> getAllContacts();

    void updateContact(Contact contact);

    boolean deleteContact(int idContact);

    Contact getContact(int idContact);
}
