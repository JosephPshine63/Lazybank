package dev.pioruocco.lazybank.controller;

import dev.pioruocco.lazybank.mapper.Mapper;
import dev.pioruocco.lazybank.model.dto.NoticeDto;
import dev.pioruocco.lazybank.model.entity.Notice;
import dev.pioruocco.lazybank.service.NoticeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.CacheControl;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.concurrent.TimeUnit;
import java.util.stream.Collectors;

@RestController
public class NoticesController {

    //sostituire tutto con service
    @Autowired
    private NoticeService noticeService;

    @Autowired
    private Mapper<Notice, NoticeDto> noticeMapper;

    @GetMapping("/notices")
    public ResponseEntity<List<NoticeDto>> getNotices() {
        List<Notice> notices = noticeService.findAllActiveNotices();
        if (notices != null) {
            return ResponseEntity.ok()
                    .cacheControl(CacheControl.maxAge(60, TimeUnit.SECONDS))
                    .body(notices.stream()
                            .map((noticeMapper::mapEntityToDto)).collect(Collectors.toList()));
        } else {
            return null;
        }
    }

}
