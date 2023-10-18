package com.freyvik.contacts.dao;

import com.freyvik.contacts.model.Contact;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.transaction.annotation.Transactional;

public interface AgendaJpa extends JpaRepository<Contact, Integer> {

    Contact findByEmail(String email);

    @Transactional
    @Modifying
    @Query("Delete from Contact c WHERE c.email=?1")
    void deleteByEmail(String email);
}
