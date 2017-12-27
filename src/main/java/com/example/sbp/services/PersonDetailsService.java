package com.example.sbp.services;

import com.example.sbp.domain.PersonDetails;

import java.util.List;

public interface PersonDetailsService {
    List<PersonDetails> listAll();

    PersonDetails getById(Long id);

    PersonDetails saveOrUpdate(PersonDetails person);

    void delete(Long id);


}
