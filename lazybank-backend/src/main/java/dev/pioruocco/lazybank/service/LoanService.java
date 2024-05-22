package dev.pioruocco.lazybank.service;

import dev.pioruocco.lazybank.model.entity.Loans;

import java.util.List;

public interface LoanService {
    List<Loans> findByCustomerIdOrderByStartDtDesc(int customerId);
}
