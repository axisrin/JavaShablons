package com.example.practice14.models;

import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.GetMapping;

import javax.persistence.*;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

@Entity
@Table(name = "users")
@Component
public class User {

    @Column (name = "first_name")
    private String firstName = "null";
    @Column (name = "last_name")
    private String lastName = "null";
    @Column (name = "middle_name")
    private String middleName = "null";
    @Column (name = "birth_date")
    private Date birthDate = null;
    private SimpleDateFormat parser = new SimpleDateFormat("yyyy-MM-dd");

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @OneToMany(mappedBy = "user", cascade = CascadeType.ALL, orphanRemoval = true)
    List<Post> posts;

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

    public Long setId(String id) {
        this.id = id;
    }

    public Long getId() {
        return id;
    }
}
