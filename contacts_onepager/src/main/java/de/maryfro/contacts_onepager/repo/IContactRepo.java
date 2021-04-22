package de.maryfro.contacts_onepager.repo;

import de.maryfro.contacts_onepager.entity.Contact;
import org.springframework.data.repository.CrudRepository;

import java.util.Collection;


public interface IContactRepo extends CrudRepository<Contact, Integer> {

    Collection<Contact> findAllByName(String name);

    Collection<Contact> findByNameLikeOrLastNameLike(String name, String lastName);

    Collection<Contact> findByNameIgnoreCaseContainingOrLastNameIgnoreCaseContaining(String name, String lastName);

}




