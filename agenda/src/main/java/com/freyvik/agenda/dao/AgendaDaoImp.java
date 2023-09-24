package com.freyvik.agenda.dao;

import com.freyvik.agenda.entity.ContactEntity;
import com.freyvik.agenda.model.Contact;
import com.freyvik.agenda.repository.AgendaJpa;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class AgendaDaoImp implements AgendaDao {

    AgendaJpa agendaJpa;

    public AgendaDaoImp(AgendaJpa agendaJpa) {
        this.agendaJpa = agendaJpa;
    }

    @Override
    public void AddContact(ContactEntity contact) {
        agendaJpa.save(contact);
    }

    @Override
    public ContactEntity getContactByEmail(String email) {
        return agendaJpa.findByEmail(email);
    }

    @Override
    public void deleteContactByEmail(String email) {
        agendaJpa.deleteByEmail(email);
    }

    @Override
    public List<ContactEntity> getContacts() {
        return agendaJpa.findAll();
    }

    @Override
    public void deleteContact(Long idContact) {
        agendaJpa.deleteById(idContact);
    }

    @Override
    public ContactEntity getContact(Long idContact) {
        return agendaJpa.findById(idContact).orElse(null);
    }

    @Override
    public void updateContact(ContactEntity contact) {
        agendaJpa.save(contact);
    }
}
