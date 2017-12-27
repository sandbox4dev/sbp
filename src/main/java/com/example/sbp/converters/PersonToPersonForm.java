package com.example.sbp.converters;
import com.example.sbp.commands.PersonForm;
import com.example.sbp.domain.Person;
import org.springframework.core.convert.converter.Converter;
import org.springframework.stereotype.Component;


@Component
public class PersonToPersonForm implements Converter<Person, PersonForm> {
    @Override
    public PersonForm convert(Person person) {
        PersonForm personForm = new PersonForm();
        personForm.setCreationTime(person.getCreationTime());
        personForm.setId(person.getId());
        personForm.setLogin(person.getLogin());
        personForm.setPassword(person.getPassword());
        personForm.setPersonDetails(person.getPersonDetails());
        return personForm;
    }
}
