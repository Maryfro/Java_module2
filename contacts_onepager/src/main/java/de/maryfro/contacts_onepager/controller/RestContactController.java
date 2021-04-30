package de.maryfro.contacts_onepager.controller;

import de.maryfro.contacts_onepager.dto.ContactDto;
import de.maryfro.contacts_onepager.entity.Contact;
import de.maryfro.contacts_onepager.service.ContactService;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.stream.Collectors;

@RequestMapping("/api/contacts")
@RestController
public class RestContactController {

    private final ContactService service;

    public RestContactController(ContactService service) {
        this.service = service;
    }

    @GetMapping
    public List<ContactDto> getAll() { // returns data in JSON format:[{name:"Max", ...}, {...}]
        List<Contact> contacts = service.getAll();
        return contacts.stream().map(contact -> new ContactDto(contact.getId(), contact.name, contact.lastName, contact.age))
                .collect(Collectors.toList());
    }

    @GetMapping("/{id}")
    public ContactDto get(@PathVariable int id) {
        Contact contact = service.get(id);
        ContactDto contactDto = new ContactDto();
        contactDto.id = id;
        contactDto.name = contact.name;
        contactDto.lastName = contact.lastName;
        contactDto.age = contact.age;
        return contactDto;
    }

    @PostMapping
    public ContactDto create(@RequestBody ContactDto contactDto) {
        Contact contact = new Contact();
        contact.setName(contactDto.name);
        contact.setLastName(contactDto.lastName);
        contact.setAge(contactDto.age);
        service.save(contact); //after saving the contact has got its id
        contactDto.id = contact.getId();
        return contactDto;
    }

    @PutMapping
    public void edit(@RequestBody ContactDto contactDto) {
        Contact contact = new Contact();
        contact.setId(contactDto.id);
        contact.setName(contactDto.name);
        contact.setLastName(contactDto.lastName);
        contact.setAge(contactDto.age);
        service.save(contact);
    }

    @DeleteMapping("/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void delete(@PathVariable int id) {
        service.remove(id);
    }

}
