package com.example.practice14.models;

import org.hibernate.annotations.Tables;
import org.springframework.stereotype.Component;

import javax.persistence.*;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

@Component
@Entity
@Table(name = "user", schema = "java_temp")
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @OneToMany(mappedBy = "user", cascade = CascadeType.ALL,orphanRemoval = true)
    private List<Post> posts;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    private String firstName = "null";
    private String lastName = "null";
    private String middleName = "null";
    private Date birthDate = null;

    public User() {
    }

    public User(String firstName, String lastName, String middleName, String birthDate) throws ParseException {
        this.firstName = firstName;
        this.lastName = lastName;
        this.middleName = middleName;
        SimpleDateFormat parser = new SimpleDateFormat("yyyy-MM-dd");
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
        SimpleDateFormat parser = new SimpleDateFormat("yyyy-MM-dd");
        this.birthDate = parser.parse(birthDate);
    }
}
