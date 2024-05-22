package dev.pioruocco.lazybank.mapper.impl;

import dev.pioruocco.lazybank.mapper.Mapper;
import dev.pioruocco.lazybank.model.dto.ContactDto;
import dev.pioruocco.lazybank.model.entity.Contact;
import org.modelmapper.ModelMapper;

public class ContactMapper implements Mapper<Contact, ContactDto> {

    private final ModelMapper modelMapper;

    public ContactMapper(ModelMapper modelMapper) {
        this.modelMapper = modelMapper;
    }

    @Override
    public ContactDto mapEntityToDto(Contact contact) {
        return modelMapper.map(contact, ContactDto.class);
    }

    @Override
    public Contact mapDtoToEntity(ContactDto contactDto) {
        return modelMapper.map(contactDto, Contact.class);
    }
}
