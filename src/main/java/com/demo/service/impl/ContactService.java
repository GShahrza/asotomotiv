package com.demo.service.impl;

import com.demo.dto.ContactDTO;
import com.demo.entity.Contact;
import com.demo.repository.ContactRepository;
import com.demo.repository.PhotosRepository;
import com.demo.service.inter.ContactServiceInter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class ContactService implements ContactServiceInter {

    private final ContactRepository contactRepository;


    private final PhotosRepository photosRepository;
    @Autowired
    public ContactService(ContactRepository contactRepository,PhotosRepository photosRepository) {
        this.contactRepository = contactRepository;
        this.photosRepository = photosRepository;
    }

    @Override
    public List<ContactDTO> getAll()
    {
        try
        {
            List<ContactDTO> contactDTOList = new ArrayList<>();
            contactRepository.findAll().forEach(contact -> contactDTOList.add(new ContactDTO(contact)));

            return contactDTOList;
        }catch (Exception ex)
        {
            return new ArrayList<>();
        }
    }

    @Override
    public ContactDTO getContact(int id)
    {
        try
        {
            return new ContactDTO(contactRepository.findById(id).get());
        }catch (Exception ex)
        {
            return new ContactDTO();
        }
    }

    @Override
    public Boolean addAndUpdateContact(Contact contact)
    {
         try
        {
            contactRepository.save(contact);
            return true;
        }catch (Exception ex)
        {
            return false;
        }
    }

    @Override
    public Boolean deleteContact(int id)
    {
        try
        {
            contactRepository.delete(contactRepository.findById(id).get());
            return true;
        }catch(Exception ex)
        {
            return false;
        }
    }

    @Override
    public Boolean deleteEmail(int id)
    {
        try
        {
            Contact contact = contactRepository.findById(id).get();
            contact.setTextEmail(null);
            contactRepository.save(contact);

            return true;
        }catch(Exception ex)
        {
            return false;
        }
    }

    @Override
    public Boolean deletePhone(int id)
    {
        try
        {
            Contact contact = contactRepository.findById(id).get();
            contact.setTextPhone(null);
            contactRepository.save(contact);

            return true;
        }catch(Exception ex)
        {
            return false;
        }
    }

    @Override
    public Boolean deleteFacebook(int id)
    {
        try
        {
            Contact contact = contactRepository.findById(id).get();
            contact.setTextFacebook(null);
            contactRepository.save(contact);
            return true;
        }catch(Exception ex)
        {
            return false;
        }
    }

    @Override
    public Boolean deleteTwitter(int id)
    {
        try
        {
            Contact contact = contactRepository.findById(id).get();
            contact.setTextTwitter(null);
            contactRepository.save(contact);

            return true;
        }catch(Exception ex)
        {
            return false;
        }
    }

    @Override
    public Boolean deleteInstagram(int id)
    {
        try
        {
            Contact contact = contactRepository.findById(id).get();
            contact.setTextEmail(null);
            contactRepository.save(contact);

            return true;
        }catch(Exception ex)
        {
            return false;
        }
    }

    @Override
    public Boolean deleteContactPhoto(int id)
    {
        try
        {
            Contact contact = contactRepository.findById(id).get();
            contact.getPhoto().setImages(null);
            photosRepository.save(contact.getPhoto());

            return true;
        }catch (Exception ex)
        {
            return false;
        }
    }

}
