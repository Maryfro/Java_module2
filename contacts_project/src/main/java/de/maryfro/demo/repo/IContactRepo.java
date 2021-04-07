package de.maryfro.demo.repo;

import de.maryfro.demo.entity.Contact;

import java.util.List;

public interface IContactRepo {

    void save(Contact contact);

    Contact find(int id);

    Contact remove(int id);

    List<Contact> findAll();

}
