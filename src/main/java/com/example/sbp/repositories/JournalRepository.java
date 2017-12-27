package com.example.sbp.repositories;

import com.example.sbp.domain.Journal;
import org.springframework.data.repository.CrudRepository;

public interface JournalRepository extends CrudRepository<Journal,Long> {
}
