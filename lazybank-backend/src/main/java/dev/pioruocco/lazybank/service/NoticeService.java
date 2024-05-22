package dev.pioruocco.lazybank.service;

import dev.pioruocco.lazybank.model.entity.Notice;

import java.util.List;

public interface NoticeService {

    List<Notice> findAllActiveNotices();

}
