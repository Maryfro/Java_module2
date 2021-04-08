package de.maryfro.demo.repo;

import de.maryfro.demo.entity.Contact;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

@Component
public class MapContactRepo implements IContactRepo {
    HashMap<Integer, Contact> contactById = new HashMap<>();
    private int id;

    @Override
    public void save(Contact contact) {
        if (contact.id > 0) {
            contactById.put(contact.getId(), contact);
        } else {
            contact.setId(++id);
            contactById.put(id, contact);
        }
    }

    @Override
    public Contact find(int id) {
        return contactById.get(id);

    }

    @Override
    public Contact remove(int id) {
        return contactById.remove(id);
    }

    @Override
    public List<Contact> findAll() {
        return new ArrayList<>(contactById.values());
    }
}
