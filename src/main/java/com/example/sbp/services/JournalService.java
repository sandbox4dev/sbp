package com.example.sbp.services;

import com.example.sbp.domain.Journal;
import java.util.List;

public interface JournalService {
    List<Journal> listAll();

    Journal getById(Long id);

    Journal saveOrUpdate(Journal person);

    void delete(Long id);



}
