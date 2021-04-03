package de.maryfro.demo.controller;

import de.maryfro.demo.entity.Contact;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

@Controller
public class ContactsController {



    /**
     * The endpoint should return the page containing
     * the list of contacts
     *
     * @return
     */
    @GetMapping("/contacts")
    public String contacts(Model model) {
        List<Contact> contacts = Arrays.asList(
                new Contact(1, "Vasya", "Vasin", 21),
                new Contact(2, "Peter", "Peterson", 22)
        );
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
       model.addAttribute("contact-for-view", new Contact());
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
    public String editContact(@PathVariable int id) {
        return "contact-form";
    }


    /**
     * The endpoint should return the page with the details of a certain contact
     * @param id the id og specified contact
     * @return
     */
    @GetMapping("/contacts/{id}")
    public String contact(@PathVariable int id, @ModelAttribute Contact contact){
       return "user-details";
    }


    /**
     * The endpoint saves either a new contact or exiting contact
     * depending on the value of the field id
     * then redirects to the /contacts page
     * @return
     */
    @PostMapping("/save-contact")
    public String saveContact(@ModelAttribute Contact contact){
        return "redirect:/contacts";
    }


    /**
     * The endpoint removes the contact and returns
     * the redirect to /contacts page.
     * @param id
     * @return
     */
    @GetMapping("/delete-contact/{id}")
    public String deleteContact(@PathVariable int id){
        return "redirect:/contacts";
    }
}
