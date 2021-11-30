package com.demo.service.inter;

import com.demo.dto.ContactDTO;
import com.demo.entity.Contact;

import java.util.List;

public interface ContactServiceInter {

    List<ContactDTO> getAll();

    ContactDTO getContact(int id);

    Boolean addAndUpdateContact(Contact contact);

    Boolean deleteContact(int id);

    Boolean deleteEmail(int id);

    Boolean deletePhone(int id);

    Boolean deleteFacebook(int id);

    Boolean deleteTwitter(int id);

    Boolean deleteInstagram(int id);

    Boolean deleteContactPhoto(int id);
}
