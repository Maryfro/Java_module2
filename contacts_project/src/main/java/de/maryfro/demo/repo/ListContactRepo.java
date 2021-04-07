package de.maryfro.demo.repo;

import de.maryfro.demo.entity.Contact;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

@Component
public class ListContactRepo implements IContactRepo {
    ArrayList<Contact> contacts = new ArrayList<>();
    static int id;


    @Override
    public void save(Contact contact) {
        if (contact.getId() > 0) {
            Contact oldContact = find(contact.getId());
            oldContact.setId(contact.getId());
            oldContact.setName(contact.getName());
            oldContact.setLastName(contact.getLastName());
            oldContact.setAge(contact.getAge());
        } else {
            // int id = Contact.getStaticId();
            contact.setId(id++);
            contacts.add(contact);
            // Contact.setStaticId(id+1);
        }
    }

    @Override
    public Contact find(int id) {
        return contacts.stream().filter(contact -> contact.getId() == id).findFirst().orElseThrow();
    }

    @Override
    public Contact remove(int id) {
        Contact toRemove = find(id);
        contacts.remove(toRemove);
        return toRemove;
    }

    @Override
    public List<Contact> findAll() {
        return contacts;
    }
}
