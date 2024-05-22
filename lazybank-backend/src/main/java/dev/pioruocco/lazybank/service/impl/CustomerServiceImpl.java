package dev.pioruocco.lazybank.service.impl;

import dev.pioruocco.lazybank.model.entity.Customer;
import dev.pioruocco.lazybank.repository.CustomerRepository;
import dev.pioruocco.lazybank.service.CustomerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@Transactional
public class CustomerServiceImpl implements CustomerService {

    @Autowired
    private CustomerRepository customerRepository;

    @Override
    public List<Customer> findByEmail(String email) {
        return customerRepository.findByEmail(email);
    }
}
