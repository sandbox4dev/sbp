package com.example.sbp.domain;

import org.hibernate.annotations.Type;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import java.time.LocalDateTime;

@Entity
public class Journal {
    @Id
    @GeneratedValue
    private Long id;
    //@Type(type = "org.hibernate.type.LocalDateTimeType")
    private LocalDateTime dateCreated;
    private int userCount;
    private double averageAge;
    private String sexCount;
    private String nationsCount;


    public Journal() {
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public LocalDateTime getDateCreated() {
        return dateCreated;
    }

    public void setDateCreated(LocalDateTime dateCreated) {
        this.dateCreated = dateCreated;
    }

    public int getUserCount() {
        return userCount;
    }

    public void setUserCount(int userCount) {
        this.userCount = userCount;
    }

    public double getAverageAge() {
        return averageAge;
    }

    public void setAverageAge(double averageAge) {
        this.averageAge = averageAge;
    }

    public String getSexCount() {
        return sexCount;
    }

    public void setSexCount(String sexCount) {
        this.sexCount = sexCount;
    }

    public String getNationsCount() {
        return nationsCount;
    }

    public void setNationsCount(String nationsCount) {
        this.nationsCount = nationsCount;
    }

    @Override
    public String toString() {
        return "Journal{" +
                "dateCreated=" + dateCreated +
                ", userCount=" + userCount +
                ", averageAge=" + averageAge +
                ", sexCount=" + sexCount +
                ", nationsCount=" + nationsCount +
                '}';
    }
}
