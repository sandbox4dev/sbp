package com.example.sbp.services;

import com.example.sbp.converters.PersonFormToPerson;
import com.example.sbp.domain.PersonDetails;
import com.example.sbp.repositories.PersonDetailsRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class PersonDetailsServiceImpl implements PersonDetailsService {

    PersonDetailsRepository personDetailsRepository;
    PersonFormToPerson personFormToPerson;

    @Autowired
    public PersonDetailsServiceImpl(PersonDetailsRepository personDetailsRepository, PersonFormToPerson personFormToPerson) {
        this.personDetailsRepository = personDetailsRepository;
        this.personFormToPerson = personFormToPerson;
    }

    @Override
    public List<PersonDetails> listAll() {
        List<PersonDetails> detailsList = new ArrayList<>();
        personDetailsRepository.findAll().forEach(detailsList::add);
        return detailsList;
    }

    @Override
    public PersonDetails getById(Long id) {
        return personDetailsRepository.findById(id).orElse(null);
        //return personDetailsRepository.findOne(id);


    }

    @Override
    public PersonDetails saveOrUpdate(PersonDetails personDetails) {
        personDetailsRepository.save(personDetails);
        return personDetails;
    }

    @Override
    public void delete(Long id) {
        personDetailsRepository.deleteById(id);
    }

}
