package dev.pioruocco.lazybank.service.impl;

import dev.pioruocco.lazybank.model.entity.Accounts;
import dev.pioruocco.lazybank.repository.AccountsRepository;
import dev.pioruocco.lazybank.service.AccountService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@Transactional
public class AccountServiceImpl implements AccountService {

    @Autowired
    private AccountsRepository accountsRepository;

    @Override
    public Accounts findByCustomerId(int customerId) {
        return accountsRepository.findByCustomerId(customerId);
    }
}
