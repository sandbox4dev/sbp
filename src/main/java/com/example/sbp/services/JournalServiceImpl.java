package com.example.sbp.services;

import com.example.sbp.domain.Journal;
import com.example.sbp.repositories.JournalRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.ArrayList;
import java.util.List;

@Service
public class JournalServiceImpl implements JournalService {

    JournalRepository journalRepository;

    @Autowired
    public JournalServiceImpl(JournalRepository journalRepository) {
        this.journalRepository = journalRepository;
    }

    @Override
    public List<Journal> listAll() {
        List<Journal> journalList = new ArrayList<>();
        journalRepository.findAll().forEach(journalList::add);
        return journalList;
    }

    @Override
    public Journal getById(Long id) {
        return journalRepository.findById(id).orElse(null);
        //return  journalRepository.findOne(id);
    }

    @Override
    public Journal saveOrUpdate(Journal journal) {
        journalRepository.save(journal);
        return journal;
    }

    @Override
    public void delete(Long id) {
        journalRepository.deleteById(id);
        //journalRepository.delete(id);
    }


}
