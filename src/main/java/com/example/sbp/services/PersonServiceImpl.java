package com.example.sbp.services;

import com.example.sbp.commands.PersonForm;
import com.example.sbp.converters.PersonFormToPerson;
import com.example.sbp.domain.Person;
import com.example.sbp.repositories.PersonDetailsRepository;
import com.example.sbp.repositories.PersonRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

@Service
public class PersonServiceImpl implements PersonService {

    PersonRepository personRepository;
    PersonFormToPerson personFormToPerson;
    PersonDetailsRepository personDetailsRepository;

    @Autowired
    public PersonServiceImpl(PersonRepository personRepository, PersonFormToPerson uF, PersonDetailsRepository personDetailsRepository) {
        this.personRepository = personRepository;
        this.personFormToPerson = uF;
        this.personDetailsRepository = personDetailsRepository;
    }




    @Override
    public List<Person> listAll() {
        List<Person> people = new ArrayList<>();
        personRepository.findAll().forEach(people::add);
        return people;
    }

    @Override
    public Person getById(Long id) {
        return personRepository.findById(id).orElse(null);
        //return personRepository.findOne(id);

    }

    @Override
    public Person saveOrUpdate(Person person) {
        person.getPersonDetails().setId(person.getId());
        personRepository.save(person);
        return person;
    }

    @Override
    public void delete(Long id) {
        personRepository.deleteById(id);
       // personRepository.delete(id);

    }

    @Override
    public Person saveOrUpdateProductForm(PersonForm personForm) {
        Person savedPerson = saveOrUpdate(personFormToPerson.convert(personForm));
        System.out.println("Saved person is " + savedPerson.getId());
        return savedPerson;
    }

    @Override
    public List<Person> findLastPerson(LocalDateTime date) {

        return personRepository.findLastPerson(date);
    }

    @Override
    public List<Person> findFirstPerson(LocalDateTime date) {
        return personRepository.findFirstPerson(date);
    }
}
