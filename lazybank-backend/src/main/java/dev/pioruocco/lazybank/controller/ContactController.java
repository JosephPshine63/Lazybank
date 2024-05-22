package dev.pioruocco.lazybank.controller;

import dev.pioruocco.lazybank.mapper.Mapper;
import dev.pioruocco.lazybank.model.dto.ContactDto;
import dev.pioruocco.lazybank.model.entity.Contact;
import dev.pioruocco.lazybank.repository.ContactRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PostFilter;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.sql.Date;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.stream.Collectors;

@RestController
public class ContactController {

    //sostituire tutto con service
    @Autowired
    private ContactRepository contactRepository;

    @Autowired
    private Mapper<Contact, ContactDto> contactContactDtoMapper;

    @PostMapping("/contact")
    @PostFilter("filterObject.contactName != 'Test'")
    public List<ContactDto> saveContactInquiryDetails(@RequestBody List<Contact> contacts) {
        Contact contact = contacts.get(0);
        contact.setContactId(getServiceReqNumber());
        contact.setCreateDt(new Date(System.currentTimeMillis()));
        contact = contactRepository.save(contact);
        List<Contact> returnContacts = new ArrayList();
        returnContacts.add(contact);

        return returnContacts.stream()
                .map((contactContactDtoMapper::mapEntityToDto)).collect(Collectors.toList());
    }

    public String getServiceReqNumber() {
        Random random = new Random();
        int ranNum = random.nextInt(999999999 - 9999) + 9999;
        return "SR" + ranNum;
    }
}
