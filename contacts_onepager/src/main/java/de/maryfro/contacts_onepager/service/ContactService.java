package de.maryfro.contacts_onepager.service;

import de.maryfro.contacts_onepager.entity.Contact;
import de.maryfro.contacts_onepager.repo.IContactRepo;
import org.springframework.stereotype.Service;

import javax.persistence.EntityNotFoundException;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;


@Service
public class ContactService {
    IContactRepo contactRepo;

    public ContactService(IContactRepo contactRepo) {
        this.contactRepo = contactRepo;
    }

    public void save(Contact contact) {
        contactRepo.save(contact);
    }

    public Contact get(int id) {
        return contactRepo.findById(id).orElseThrow(EntityNotFoundException::new);
    }


    public Contact remove(int id) {
        Contact res = get(id);
        contactRepo.deleteById(id);
        return res;
    }


    public List<Contact> getAll() {
        Iterable<Contact> contacts = contactRepo.findAll();
        List<Contact> res = new ArrayList<>();
        for (Contact c : contacts) {
            res.add(c);
        }
        return res;
    }

    public Collection<Contact> findAllByName(String name){
      return contactRepo.findAllByName(name);
    }

    public Collection<Contact> findByNameLikeOrLastNameLike(String name, String lastName){
        return contactRepo.findByNameLikeOrLastNameLike(name, lastName);
    }

    public Collection<Contact> findByNameContainingOrLastNameContaining(String name, String lastName){
        return contactRepo.findByNameIgnoreCaseContainingOrLastNameIgnoreCaseContaining(name, lastName);
    }
}
