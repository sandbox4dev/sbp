package com.example.sbp.services;

import com.example.sbp.commands.PersonForm;
import com.example.sbp.domain.Person;

import java.time.LocalDateTime;
import java.util.List;

public interface PersonService {

    List<Person> listAll();

    Person getById(Long id);

    Person saveOrUpdate(Person person);

    void delete(Long id);

    Person saveOrUpdateProductForm(PersonForm personForm);

    List<Person> findLastPerson(LocalDateTime date);
    List<Person> findFirstPerson(LocalDateTime date);


}
