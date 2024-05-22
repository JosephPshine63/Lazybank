package dev.pioruocco.lazybank.mapper.impl;

import dev.pioruocco.lazybank.mapper.Mapper;
import dev.pioruocco.lazybank.model.dto.AccountDto;
import dev.pioruocco.lazybank.model.entity.Accounts;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Component;

@Component
public class AccountMapper implements Mapper<Accounts, AccountDto> {

    private final ModelMapper modelMapper;

    public AccountMapper(ModelMapper modelMapper) {
        this.modelMapper = modelMapper;
    }

    @Override
    public AccountDto mapEntityToDto(Accounts accounts) {
        return modelMapper.map(accounts, AccountDto.class);
    }

    @Override
    public Accounts mapDtoToEntity(AccountDto accountDto) {
        return modelMapper.map(accountDto, Accounts.class);
    }
}
