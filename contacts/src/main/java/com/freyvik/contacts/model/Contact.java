package com.freyvik.contacts.model;

import jakarta.persistence.*;

@Entity
@Table(name = "contactos")
@NamedQuery(name = "Contact.findAll", query = "SELECT c FROM Contact c")
public class Contact {

    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "idContacto")
    private int idContact;

    @Column(name = "edad")
    private int age;

    private String email;

    @Column(name = "nombre")
    private String name;

    public int getIdContact() {
        return idContact;
    }
    public void setIdContact(int idContact) {
        this.idContact = idContact;
    }

    public int getAge() {
        return age;
    }
    public void setAge(int age) {
        this.age = age;
    }

    public String getEmail() {
        return email;
    }
    public void setEmail(String email) {
        this.email = email;
    }

    public String getName() {
        return name;
    }
    public void setName(String name) {
        this.name = name;
    }
}
