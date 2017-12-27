package com.example.sbp.schedulers;

import com.example.sbp.domain.Journal;
import com.example.sbp.domain.Person;
import com.example.sbp.services.JournalService;
import com.example.sbp.services.PersonService;
import com.example.sbp.utils.FunctionalProperty;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.EnableScheduling;
import org.springframework.scheduling.annotation.Scheduled;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.function.Function;
import java.util.function.UnaryOperator;
import java.util.stream.Collectors;


@EnableScheduling
public class Scheduler {

    @Autowired
    private PersonService personService;

    @Autowired
    private JournalService journalService;


    public Scheduler() {
    }

    @Scheduled(fixedRate = 60000)
    public synchronized void doStatistic() {
        Journal journal = new Journal();

        LocalDateTime timeToDie = LocalDateTime.of(LocalDate.now(), LocalTime.now().minusSeconds(120));
        LocalDateTime timeToLive = LocalDateTime.of(LocalDate.now(), LocalTime.now().minusSeconds(60));


        List<Person> personList = personService.findLastPerson(timeToLive);
        if (personList.size() > 0) {
            journal.setAverageAge(personList.stream().mapToInt(cnt -> cnt.getPersonDetails().getAge()).average().getAsDouble());
            journal.setUserCount(personList.size());
            journal.setSexCount(getAverageCountForProperty(personList, person -> person.getPersonDetails().getSex()).toString());
            journal.setNationsCount(getAverageCountForProperty(personList, person -> person.getPersonDetails().getCountry()).toString());
            journal.setDateCreated(timeToLive);
            journalService.saveOrUpdate(journal);
        }
        personService.findFirstPerson(timeToDie).forEach(person -> personService.delete(person.getId()));

    }


    public static Map<String, Long> getAverageCountForProperty(List<Person> personList, FunctionalProperty<Person> property){
        List<String> props = new ArrayList<>();
        personList.forEach(person -> props.add(property.getValue(person)));
        return props.stream().collect(Collectors.groupingBy(Function.identity(),Collectors.counting()));
    }


}
