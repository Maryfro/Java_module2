package de.maryfro.demo.service;

import de.maryfro.demo.entity.Contact;
import de.maryfro.demo.repo.IContactRepo;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ContactService {
    IContactRepo contactRepo;

    public ContactService(@Qualifier("listContactRepo") IContactRepo contactRepo) {
        this.contactRepo = contactRepo;
    }

    public void save(Contact contact) {
        contactRepo.save(contact);
    }

    public Contact get(int id) {
        return contactRepo.find(id);
    }


    public Contact remove(int id) {
        return contactRepo.remove(id);
    }


    public List<Contact> getAll() {
        return contactRepo.findAll();
    }
}
