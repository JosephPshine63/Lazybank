package dev.pioruocco.lazybank.controller;

import dev.pioruocco.lazybank.mapper.Mapper;
import dev.pioruocco.lazybank.model.dto.CustomerDto;
import dev.pioruocco.lazybank.model.entity.Customer;
import dev.pioruocco.lazybank.service.CustomerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class LoginController {

    //sostituire tutto con service
    @Autowired
    private CustomerService customerService;

    @Autowired
    private Mapper<Customer, CustomerDto> customerMapper;

    @RequestMapping("/user")
    public CustomerDto getUserDetailsAfterLogin(Authentication authentication) {
        List<Customer> customers = customerService.findByEmail(authentication.getName());
        if (customers.size() > 0) {
            return customerMapper.mapEntityToDto(customers.get(0));
        } else {
            return null;
        }

    }

}
