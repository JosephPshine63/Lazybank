package dev.pioruocco.lazybank.mapper.impl;

import dev.pioruocco.lazybank.mapper.Mapper;
import dev.pioruocco.lazybank.model.dto.AuthorityDto;
import dev.pioruocco.lazybank.model.entity.Authority;
import org.modelmapper.ModelMapper;

public class AuthorityMapper implements Mapper<Authority, AuthorityDto> {

    private final ModelMapper modelMapper;

    public AuthorityMapper(ModelMapper modelMapper) {
        this.modelMapper = modelMapper;
    }

    @Override
    public AuthorityDto mapEntityToDto(Authority authority) {
        return modelMapper.map(authority, AuthorityDto.class);
    }

    @Override
    public Authority mapDtoToEntity(AuthorityDto authorityDto) {
        return modelMapper.map(authorityDto, Authority.class);
    }
}
