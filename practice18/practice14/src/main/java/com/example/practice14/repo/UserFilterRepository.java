package com.example.practice14.repo;

import com.example.practice14.models.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.sql.Date;
import java.util.List;

@Repository
public interface UserFilterRepository {
    List<User> findUsersByFirstNameAndLastNameAndMiddleNameAndBirthDate(
            String firstName, String lastName, String middleName, Date birthDate);
}
