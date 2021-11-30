package com.demo.controller;

import com.demo.dto.ContactDTO;
import com.demo.entity.Contact;
import com.demo.service.impl.ContactService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@CrossOrigin(origins = "*", allowedHeaders = "*",methods = {RequestMethod.DELETE,RequestMethod.GET,RequestMethod.POST})
@RequestMapping("/contact")
public class ContactRestController {

    private final ContactService contactService;
    @Autowired
    public ContactRestController(ContactService contactService) {
        this.contactService = contactService;
    }

    @GetMapping("/getAll")
    public List<ContactDTO> getAll()
    {
        return contactService.getAll();
    }

    @GetMapping("/getContact/{id}")
    public ContactDTO getContact(@PathVariable int id)
    {
        return contactService.getContact(id);
    }

    @PostMapping("/update")
    public Boolean updateContact(@RequestBody Contact contact)
    {
        return contactService.addAndUpdateContact(contact);
    }

    @DeleteMapping("/delete/contact/{id}")
    public Boolean deleteContact(@PathVariable int id)
    {
        return contactService.deleteContact(id);
    }

    @DeleteMapping("/delete/email/{id}")
    public Boolean deleteEmail(@PathVariable int id)
    {
        return contactService.deleteEmail(id);
    }

    @DeleteMapping("/delete/phone/{id}")
    public Boolean deletePhone(@PathVariable int id)
    {
        return contactService.deletePhone(id);
    }

    @DeleteMapping("/delete/facebook/{id}")
    public Boolean deleteFacebook(@PathVariable int id)
    {
        return contactService.deleteFacebook(id);
    }

    @DeleteMapping("/delete/twitter/{id}")
    public Boolean deleteTwitter(@PathVariable int id)
    {
        return contactService.deleteTwitter(id);
    }

    @DeleteMapping("/delete/instagram/{id}")
    public Boolean deleteInstagram(@PathVariable int id)
    {
        return contactService.deleteInstagram(id);
    }

}
