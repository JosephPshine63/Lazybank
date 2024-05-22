package dev.pioruocco.lazybank.service;

import dev.pioruocco.lazybank.model.entity.Customer;

import java.util.List;

public interface CustomerService {
    List<Customer> findByEmail(String email);
}
