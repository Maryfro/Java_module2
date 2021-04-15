package de.maryfro.contacts_repo.controller;

import de.maryfro.contacts_repo.dto.SearchForm;
import de.maryfro.contacts_repo.entity.Contact;
import de.maryfro.contacts_repo.service.ContactService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import java.util.Arrays;
import java.util.Collection;
import java.util.List;

@Controller
public class ContactsController {

    private final ContactService service;

    public ContactsController(ContactService service) {
        this.service = service;
    }

    /**
     * The endpoint should return the page containing
     * the list of contacts
     *
     * @return
     */
    @GetMapping("/contacts")
    public String contacts(Model model) {
        List<Contact> contacts = service.getAll();
        model.addAttribute("contacts", contacts);
        return "contacts";
    }

    /**
     * The endpoint should return the page with the empty form
     * for creating a new contact
     *
     * @return
     */
    @GetMapping("/add-contact")
    public String addContact(Model model) {
        model.addAttribute("contact", new Contact());
        return "contact-form";
    }

    /**
     * The endpoint should return the page with the form filled in with a
     * certain contact.
     *
     * @param id the id og specified contact
     * @return
     */
    @GetMapping("/edit-contact/{id}")
    public String editContact(@PathVariable int id, Model model) {
        Contact contact = service.get(id);
        model.addAttribute("contact", contact);
        return "contact-form";
    }


    /**
     * The endpoint should return the page with the details of a certain contact
     *
     * @param id the id og specified contact
     * @return
     */
    @GetMapping("/contacts/{id}")
    public String contact(@PathVariable int id, Model model) {
        Contact contact = service.get(id);
        model.addAttribute("contact", contact);
        return "user-details";
    }


    /**
     * The endpoint saves either a new contact or exiting contact
     * depending on the value of the field id
     * then redirects to the /contacts page
     *
     * @return
     */
    @PostMapping("/save-contact")
    public String saveContact(@ModelAttribute Contact contact) {
        service.save(contact);
        return "redirect:/contacts";
    }


    /**
     * The endpoint removes the contact and returns
     * the redirect to /contacts page.
     *
     * @param id
     * @return
     */
    @GetMapping("/delete-contact/{id}")
    public String deleteContact(@PathVariable int id) {
        service.remove(id);
        return "redirect:/contacts";
    }

    @GetMapping("/")
    public String mainPage() {
        return "forward:/contacts";
    }

    @PostMapping("/contacts/search")
    public String searchContacts(@ModelAttribute SearchForm formInput, Model model) {
        Collection<Contact> res = service.findByNameContainingOrLastNameContaining(formInput.searchPattern, formInput.searchPattern);
        model.addAttribute("sp", res);
        model.addAttribute("contacts", res);
        return "contacts";
    }


}
