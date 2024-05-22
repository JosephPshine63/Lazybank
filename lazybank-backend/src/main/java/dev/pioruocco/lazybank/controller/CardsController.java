package dev.pioruocco.lazybank.controller;

import dev.pioruocco.lazybank.mapper.Mapper;
import dev.pioruocco.lazybank.model.dto.CardsDto;
import dev.pioruocco.lazybank.model.entity.Cards;
import dev.pioruocco.lazybank.model.entity.Customer;
import dev.pioruocco.lazybank.service.CardService;
import dev.pioruocco.lazybank.service.CustomerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.stream.Collectors;

@RestController
public class CardsController {

    //sostituire tutto con service
    @Autowired
    private CardService cardService;

    @Autowired
    private CustomerService customerService;

    @Autowired
    private Mapper<Cards, CardsDto> cardsCardsDtoMapper;

    @GetMapping("/myCards")
    public List<CardsDto> getCardDetails(@RequestParam String email) {
        List<Customer> customers = customerService.findByEmail(email);
        if (customers != null && !customers.isEmpty()) {
            List<Cards> cards = cardService.findByCustomerId(customers.get(0).getId());
            if (cards != null) {
                return cards.stream()
                        .map((cardsCardsDtoMapper::mapEntityToDto)).collect(Collectors.toList());
            }
        }
        return null;
    }

}
