package dev.pioruocco.lazybank.controller;

import dev.pioruocco.lazybank.mapper.Mapper;
import dev.pioruocco.lazybank.model.dto.LoansDto;
import dev.pioruocco.lazybank.model.entity.Customer;
import dev.pioruocco.lazybank.model.entity.Loans;
import dev.pioruocco.lazybank.service.CustomerService;
import dev.pioruocco.lazybank.service.LoanService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.stream.Collectors;

@RestController
public class LoansController {

    //sostituire tutto con service
    @Autowired
    private LoanService loanService;

    @Autowired
    private CustomerService customerService;

    @Autowired
    private Mapper<Loans, LoansDto> loansLoansDtoMapper;

    @GetMapping("/myLoans")
    public List<LoansDto> getLoanDetails(@RequestParam String email) {
        List<Customer> customers = customerService.findByEmail(email);
        if (customers != null && !customers.isEmpty()) {
            List<Loans> loans = loanService.findByCustomerIdOrderByStartDtDesc(customers.get(0).getId());
            if (loans != null) {
                return loans.stream()
                        .map((loansLoansDtoMapper::mapEntityToDto)).collect(Collectors.toList());
            }
        }
        return null;
    }

}
