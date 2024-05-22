package dev.pioruocco.lazybank.service.impl;

import dev.pioruocco.lazybank.model.entity.Loans;
import dev.pioruocco.lazybank.repository.LoanRepository;
import dev.pioruocco.lazybank.service.LoanService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@Transactional
public class LoanServiceImpl implements LoanService {

    @Autowired
    private LoanRepository loanRepository;

    @Override
    public List<Loans> findByCustomerIdOrderByStartDtDesc(int customerId) {
        return loanRepository.findByCustomerIdOrderByStartDtDesc(customerId);
    }
}
