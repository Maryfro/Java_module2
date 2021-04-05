package de.maryfro.demo.controller;

import de.maryfro.demo.entity.Contact;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@Controller
public class ContactsController {
    List<Contact> contacts = new ArrayList<>();

    public ContactsController() {
        contacts.add(new Contact("Vasya", "Vasin", 21));
        contacts.add(new Contact("Peter", "Peterson", 22));
    }


    /**
     * The endpoint should return the page containing
     * the list of contacts
     *
     * @return
     */
    @GetMapping("/contacts")
    public String contacts(Model model) {
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
        Contact nc = new Contact();
        int id = Contact.getStaticId();
        nc.setId(id);
        model.addAttribute("contact", nc);
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
        for (Contact contact : contacts) {
            if (contact.getId() == id)
                model.addAttribute("contact", contact);
        }
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
        Contact needed = new Contact();
        for (Contact c : contacts) {
            if (c.getId() == id)
                needed = c;
        }
        model.addAttribute("needed_contact", needed);
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
        if (contact.getId() < Contact.getStaticId()) {
            contacts.set(contact.getId(), contact);
        } else {
            int staticId = Contact.getStaticId();
                contacts.add(contact);
                staticId++;
                Contact.setStaticId(staticId);
            }
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
        public String deleteContact ( @PathVariable int id){
            contacts.remove(id);
            return "redirect:/contacts";
        }
    }
