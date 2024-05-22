package dev.pioruocco.lazybank.service;

import dev.pioruocco.lazybank.model.entity.Accounts;

public interface AccountService {
    Accounts findByCustomerId(int customerId);
}
