package com.example.sbp.repositories;

import com.example.sbp.domain.PersonDetails;
import org.springframework.data.repository.CrudRepository;

public interface PersonDetailsRepository extends CrudRepository<PersonDetails, Long> {
}
