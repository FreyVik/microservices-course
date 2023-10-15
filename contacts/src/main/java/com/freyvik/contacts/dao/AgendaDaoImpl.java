package com.freyvik.contacts.dao;

import com.freyvik.contacts.model.Contact;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class AgendaDaoImpl implements AgendaDao {

    @Autowired
    AgendaJpa agenda;

    @Override
    public void addContact(Contact contact) {
        agenda.save(contact);
    }

    @Override
    public Contact getContact(String email) {
        return agenda.findByEmail(email);
    }

    @Override
    public void deleteContact(String email) {
        agenda.deleteByEmail(email);
    }

    @Override
    public List<Contact> findAll() {
        return agenda.findAll();
    }

    @Override
    public Contact getContact(int idContact) {
        return agenda.findById(idContact).orElse(null);
    }

    @Override
    public void deleteContact(int idContact) {
        agenda.deleteById(idContact);
    }

    @Override
    public void updateContact(Contact contact) {
        agenda.save(contact);
    }
}
