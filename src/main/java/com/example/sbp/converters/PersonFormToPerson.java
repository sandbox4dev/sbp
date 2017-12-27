package com.example.sbp.converters;

import com.example.sbp.commands.PersonForm;
import com.example.sbp.domain.Person;
import com.example.sbp.domain.PersonDetails;
import com.example.sbp.utils.Randomizer;
import org.springframework.core.convert.converter.Converter;
import org.springframework.stereotype.Component;
import org.thymeleaf.util.StringUtils;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.util.UUID;

@Component
public class PersonFormToPerson implements Converter<PersonForm, Person> {
    @Override
    public Person convert(PersonForm personForm) {
        Person person = new Person();
        PersonDetails personDetails = new PersonDetails();
        personDetails.setPerson(person);
        personDetails.setAge(Randomizer.getRandomInt(10,50));
        personDetails.setName(Randomizer.getRandomString());
        personDetails.setSurname(Randomizer.getRandomString());
        personDetails.setSex(Randomizer.getRandomSex());
        personDetails.setCountry(Randomizer.getRandomCountry());
        personDetails.setId(person.getId());
        if (personForm.getId()!=null && !StringUtils.isEmpty(personForm.getId().toString())){
            person.setId(new Long(personForm.getId()));
        }
        LocalDateTime today = LocalDateTime.of(LocalDate.now(), LocalTime.now());
        person.setCreationTime(today);
        person.setLogin(personForm.getLogin());
        person.setPassword(personForm.getPassword());
        person.setUuid(UUID.randomUUID());
        person.setPersonDetails(personDetails);
        return person;
    }
}
