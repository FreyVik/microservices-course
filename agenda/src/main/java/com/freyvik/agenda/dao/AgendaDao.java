package com.freyvik.agenda.dao;

import com.freyvik.agenda.entity.ContactEntity;

import java.util.List;

public interface AgendaDao {

    void AddContact(ContactEntity contact);

    ContactEntity getContactByEmail(String email);

    void deleteContactByEmail(String email);

    List<ContactEntity> getContacts();

    void deleteContact(Long idContact);

    ContactEntity getContact(Long idContact);

    void updateContact(ContactEntity contact);
}
