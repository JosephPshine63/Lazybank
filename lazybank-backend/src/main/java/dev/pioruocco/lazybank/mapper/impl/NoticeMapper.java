package dev.pioruocco.lazybank.mapper.impl;

import dev.pioruocco.lazybank.mapper.Mapper;
import dev.pioruocco.lazybank.model.dto.NoticeDto;
import dev.pioruocco.lazybank.model.entity.Notice;
import org.modelmapper.ModelMapper;

public class NoticeMapper implements Mapper<Notice, NoticeDto> {

    private final ModelMapper modelMapper;

    public NoticeMapper(ModelMapper modelMapper) {
        this.modelMapper = modelMapper;
    }

    @Override
    public NoticeDto mapEntityToDto(Notice notice) {
        return modelMapper.map(notice, NoticeDto.class);
    }

    @Override
    public Notice mapDtoToEntity(NoticeDto noticeDto) {
        return modelMapper.map(noticeDto, Notice.class);
    }
}
