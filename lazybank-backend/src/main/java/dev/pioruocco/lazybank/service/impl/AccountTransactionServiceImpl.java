package dev.pioruocco.lazybank.service.impl;

import dev.pioruocco.lazybank.model.entity.AccountTransactions;
import dev.pioruocco.lazybank.repository.AccountTransactionsRepository;
import dev.pioruocco.lazybank.service.AccountTransactionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@Transactional
public class AccountTransactionServiceImpl implements AccountTransactionService {

    @Autowired
    private AccountTransactionsRepository accountTransactionsRepository;

    @Override
    public List<AccountTransactions> findByCustomerIdOrderByTransactionDtDesc(int customerId) {
        return accountTransactionsRepository.findByCustomerIdOrderByTransactionDtDesc(customerId);
    }
}
