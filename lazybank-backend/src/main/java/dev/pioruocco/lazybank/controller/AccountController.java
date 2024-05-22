package dev.pioruocco.lazybank.controller;

import dev.pioruocco.lazybank.mapper.Mapper;
import dev.pioruocco.lazybank.mapper.impl.AccountMapper;
import dev.pioruocco.lazybank.model.dto.AccountDto;
import dev.pioruocco.lazybank.model.entity.Accounts;
import dev.pioruocco.lazybank.model.entity.Customer;
import dev.pioruocco.lazybank.service.AccountService;
import dev.pioruocco.lazybank.service.CustomerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class AccountController {

    //sostituire tutto con service
    @Autowired
    private AccountService accountService;

    @Autowired
    private CustomerService customerService;

    @Autowired
    private Mapper<Accounts, AccountDto> accountMapper;

    @GetMapping("/myAccount")
    public AccountDto getAccountDetails(@RequestParam String email) {
        List<Customer> customers = customerService.findByEmail(email);
        if (customers != null && !customers.isEmpty()) {
            Accounts accounts = accountService.findByCustomerId(customers.get(0).getId());
            if (accounts != null) {
                return accountMapper.mapEntityToDto(accounts);
            }
        }
        return null;
    }
}
