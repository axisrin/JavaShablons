package com.example.practice14.dto;

import lombok.Getter;
import lombok.Setter;

import java.sql.Date;

@Setter
@Getter
public class FilterUsersDTO {
    private String firstName;
    private String lastName;
    private String middleName;
    private Date birthDate;
}
