package com.example.practice14.models;

import org.springframework.stereotype.Component;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

@Component
public class User {

    private String firstName = "null";
    private String lastName = "null";
    private String middleName = "null";
    private Date birthDate = null;
    private final SimpleDateFormat parser = new SimpleDateFormat("yyyy-MM-dd");

    public User() {
    }

    public User(String firstName, String lastName, String middleName, String birthDate) throws ParseException {
        this.firstName = firstName;
        this.lastName = lastName;
        this.middleName = middleName;
        this.birthDate = parser.parse(birthDate);
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getMiddleName() {
        return middleName;
    }

    public void setMiddleName(String middleName) {
        this.middleName = middleName;
    }

    public Date getBirthDate() {
        return birthDate;
    }

    public void setBirthDate(String birthDate) throws ParseException {
        this.birthDate = parser.parse(birthDate);
    }
}
