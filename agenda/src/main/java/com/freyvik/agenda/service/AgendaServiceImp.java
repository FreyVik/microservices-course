package com.freyvik.agenda.service;

import com.freyvik.agenda.dao.AgendaDao;
import com.freyvik.agenda.entity.ContactEntity;
import com.freyvik.agenda.model.Contact;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class AgendaServiceImp implements AgendaService {

    @Autowired
    AgendaDao agendaDao;

    @Override
    public boolean addContact(ContactEntity contact) {
        if(agendaDao.getContact(contact.getIdContacto()) == null) {
            agendaDao.addContact(contact);
            return Boolean.TRUE;
        }
        return false;
    }

    @Override
    public List<ContactEntity> getContacts() {
        return agendaDao.getContacts();
    }

    @Override
    public void updateContact(ContactEntity contact) {
        if(agendaDao.getContact(contact.getIdContacto()) != null) {
            agendaDao.addContact(contact);
        }
    }

    @Override
    public boolean deleteContact(Long idContact) {
        if(agendaDao.getContact(idContact) != null) {
            agendaDao.deleteContact(idContact);
            return Boolean.TRUE;
        }
        return false;
    }

    @Override
    public ContactEntity findContact(Long idContact) {
        return agendaDao.getContact(idContact);
    }
}
