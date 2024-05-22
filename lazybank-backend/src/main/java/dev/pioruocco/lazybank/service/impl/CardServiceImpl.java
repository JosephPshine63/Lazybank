package dev.pioruocco.lazybank.service.impl;

import dev.pioruocco.lazybank.model.entity.Cards;
import dev.pioruocco.lazybank.repository.CardsRepository;
import dev.pioruocco.lazybank.service.CardService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@Transactional
public class CardServiceImpl implements CardService {

    @Autowired
    private CardsRepository cardsRepository;

    @Override
    public List<Cards> findByCustomerId(int customerId) {
        return cardsRepository.findByCustomerId(customerId);
    }
}
