package com.freyvik.agenda.repository;

import com.freyvik.agenda.entity.ContactEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.transaction.annotation.Transactional;

public interface AgendaJpa extends JpaRepository<ContactEntity, Long> {

    ContactEntity findByEmail(String email);

    @Transactional
    @Modifying
    @Query("DELETE FROM ContactEntity c WHERE c.email=?1")
    void deleteByEmail(String email);
}
