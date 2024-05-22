package dev.pioruocco.lazybank.mapper.impl;

import dev.pioruocco.lazybank.mapper.Mapper;
import dev.pioruocco.lazybank.model.dto.LoansDto;
import dev.pioruocco.lazybank.model.entity.Loans;
import org.modelmapper.ModelMapper;

public class LoansMapper implements Mapper<Loans, LoansDto> {

    private final ModelMapper modelMapper;

    public LoansMapper(ModelMapper modelMapper) {
        this.modelMapper = modelMapper;
    }

    @Override
    public LoansDto mapEntityToDto(Loans loans) {
        return modelMapper.map(loans, LoansDto.class);
    }

    @Override
    public Loans mapDtoToEntity(LoansDto loansDto) {
        return modelMapper.map(loansDto, Loans.class);
    }
}
