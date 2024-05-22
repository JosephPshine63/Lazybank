package dev.pioruocco.lazybank.controller;

import dev.pioruocco.lazybank.mapper.Mapper;
import dev.pioruocco.lazybank.model.dto.AccountTransactionDto;
import dev.pioruocco.lazybank.model.entity.AccountTransactions;
import dev.pioruocco.lazybank.model.entity.Customer;
import dev.pioruocco.lazybank.service.AccountTransactionService;
import dev.pioruocco.lazybank.service.CustomerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.stream.Collectors;

@RestController
public class BalanceController {

    //sostituire tutto con service
    @Autowired
    private CustomerService customerService;

    @Autowired
    private AccountTransactionService accountTransactionService;

    @Autowired
    private Mapper<AccountTransactions, AccountTransactionDto> accountTransactionsAccountTransactionDtoMapper;

    @GetMapping("/myBalance")
    public List<AccountTransactionDto> getBalanceDetails(@RequestParam String email) {
        List<Customer> customers = customerService.findByEmail(email);
        if (customers != null && !customers.isEmpty()) {
            List<AccountTransactions> accountTransactions = accountTransactionService.
                    findByCustomerIdOrderByTransactionDtDesc(customers.get(0).getId());
            if (accountTransactions != null) {
                return accountTransactions.stream()
                        .map((accountTransactionsAccountTransactionDtoMapper::mapEntityToDto)).collect(Collectors.toList());
            }
        }
        return null;
    }
}
