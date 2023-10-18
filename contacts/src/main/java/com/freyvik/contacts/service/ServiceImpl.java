package com.freyvik.contacts.service;

import com.freyvik.contacts.dao.AgendaDao;
import com.freyvik.contacts.model.Contact;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ServiceImpl implements AgendaService {

    @Autowired
    AgendaDao agendaDao;

    @Override
    public boolean addContact(Contact contact) {
        if (agendaDao.getContact(contact.getIdContact()) == null) {
            agendaDao.addContact(contact);
            return Boolean.TRUE;
        }

        return Boolean.FALSE;
    }

    @Override
    public List<Contact> getAllContacts() {
        try {
            System.out.println("Getting all contacts");
            Thread.sleep(10000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        System.out.println("All contacts found");
        return agendaDao.findAll();
    }

    @Override
    public void updateContact(Contact contact) {
        if (agendaDao.getContact(contact.getIdContact()) != null) {
            agendaDao.updateContact(contact);
        }
    }

    @Override
    public boolean deleteContact(int idContact) {
        if (agendaDao.getContact(idContact) != null) {
            agendaDao.deleteContact(idContact);
            return true;
        }

        return false;
    }

    @Override
    public Contact getContact(int idContact) {
        return agendaDao.getContact(idContact);
    }
}
