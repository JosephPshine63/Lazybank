package dev.pioruocco.lazybank.mapper.impl;

import dev.pioruocco.lazybank.mapper.Mapper;
import dev.pioruocco.lazybank.model.dto.CustomerDto;
import dev.pioruocco.lazybank.model.entity.Customer;
import org.modelmapper.ModelMapper;

public class CustomerMapper implements Mapper<Customer, CustomerDto> {

    private final ModelMapper modelMapper;

    public CustomerMapper(ModelMapper modelMapper) {
        this.modelMapper = modelMapper;
    }

    @Override
    public CustomerDto mapEntityToDto(Customer customer) {
        return modelMapper.map(customer, CustomerDto.class);
    }

    @Override
    public Customer mapDtoToEntity(CustomerDto customerDto) {
        return modelMapper.map(customerDto, Customer.class);
    }
}
