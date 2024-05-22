package dev.pioruocco.lazybank.mapper.impl;

import dev.pioruocco.lazybank.mapper.Mapper;
import dev.pioruocco.lazybank.model.dto.CardsDto;
import dev.pioruocco.lazybank.model.entity.Cards;
import org.modelmapper.ModelMapper;

public class CardMapper implements Mapper<Cards, CardsDto> {

    private final ModelMapper modelMapper;

    public CardMapper(ModelMapper modelMapper) {
        this.modelMapper = modelMapper;
    }

    @Override
    public CardsDto mapEntityToDto(Cards cards) {
        return modelMapper.map(cards, CardsDto.class);
    }

    @Override
    public Cards mapDtoToEntity(CardsDto cardsDto) {
        return modelMapper.map(cardsDto, Cards.class);
    }
}
