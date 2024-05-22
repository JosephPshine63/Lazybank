package dev.pioruocco.lazybank.service.impl;

import dev.pioruocco.lazybank.model.entity.Notice;
import dev.pioruocco.lazybank.repository.NoticeRepository;
import dev.pioruocco.lazybank.service.NoticeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@Transactional
public class NoticeServiceImpl implements NoticeService {

    @Autowired
    private NoticeRepository noticeRepository;

    @Override
    public List<Notice> findAllActiveNotices() {
        return noticeRepository.findAllActiveNotices();
    }
}
