package dev.pioruocco.lazybank.mapper.impl;

import dev.pioruocco.lazybank.mapper.Mapper;
import dev.pioruocco.lazybank.model.dto.AccountTransactionDto;
import dev.pioruocco.lazybank.model.entity.AccountTransactions;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Component;

@Component
public class AccountTranscationMapper implements Mapper<AccountTransactions, AccountTransactionDto> {

    private final ModelMapper modelMapper;


    public AccountTranscationMapper(ModelMapper modelMapper) {
        this.modelMapper = modelMapper;
    }

    @Override
    public AccountTransactionDto mapEntityToDto(AccountTransactions accountTransactions) {
        return modelMapper.map(accountTransactions, AccountTransactionDto.class);
    }

    @Override
    public AccountTransactions mapDtoToEntity(AccountTransactionDto accountTransactionDto) {
        return modelMapper.map(accountTransactionDto, AccountTransactions.class);
    }
}
