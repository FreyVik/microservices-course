package com.freyvik.agenda.entity;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Entity
@Table(name = "contactos")
public class ContactEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    Long idContacto;

    @Column(name = "nombre")
    String name;

    String email;

    @Column(name = "edad")
    Integer age;
}
