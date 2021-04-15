package de.maryfro.contacts_repo.repo;

import de.maryfro.contacts_repo.entity.Contact;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.util.Streamable;

import java.util.Collection;


public interface IContactRepo extends CrudRepository<Contact, Integer> {

    Collection<Contact> findAllByName(String name);

    Collection<Contact> findByNameLikeOrLastNameLike(String name, String lastName);

    Collection<Contact> findByNameContainingOrLastNameContaining(String name, String lastName);

}




