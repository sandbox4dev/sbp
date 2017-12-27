package com.example.sbp.repositories;

import com.example.sbp.domain.Person;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;

import java.time.LocalDateTime;
import java.util.List;

public interface PersonRepository extends CrudRepository<Person, Long> {

    @Query("SELECT p from Person p where p.creationTime >= :date")
    List<Person> findLastPerson(@Param("date")LocalDateTime date);

    @Query("SELECT p from Person p where p.creationTime < :date")
    List<Person> findFirstPerson(@Param("date")LocalDateTime date);
}
