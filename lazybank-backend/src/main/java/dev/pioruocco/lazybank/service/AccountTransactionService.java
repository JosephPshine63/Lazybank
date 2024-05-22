package dev.pioruocco.lazybank.service;

import dev.pioruocco.lazybank.model.entity.AccountTransactions;

import java.util.List;

public interface AccountTransactionService {
    List<AccountTransactions> findByCustomerIdOrderByTransactionDtDesc(int customerId);
}
