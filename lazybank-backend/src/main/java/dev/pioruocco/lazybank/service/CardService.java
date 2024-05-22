package dev.pioruocco.lazybank.service;

import dev.pioruocco.lazybank.model.entity.Cards;

import java.util.List;

public interface CardService {
    List<Cards> findByCustomerId(int customerId);
}
