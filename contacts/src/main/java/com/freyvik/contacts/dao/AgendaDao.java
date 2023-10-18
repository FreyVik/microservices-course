package com.freyvik.contacts.dao;

import com.freyvik.contacts.model.Contact;

import java.util.List;

public interface AgendaDao {

    void addContact(Contact contact);

    Contact getContact(String email);

    void deleteContact(String email);

    List<Contact> findAll();

    Contact getContact(int idContact);

    void deleteContact(int idContact);

    void updateContact(Contact contact);
}
