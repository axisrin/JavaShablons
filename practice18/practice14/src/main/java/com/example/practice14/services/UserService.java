package com.example.practice14.services;

import com.example.practice14.loggingAspect.LogExecutionTime;
import com.example.practice14.models.User;
import com.example.practice14.repo.UserRepository;
import lombok.RequiredArgsConstructor;
import org.hibernate.Session;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;



import java.text.ParseException;
import java.util.ArrayList;

@Service
@RequiredArgsConstructor
public class UserService {
    @Autowired
    UserRepository userRepository;

    private Session sessionFactory;

    public void save(User user) throws ParseException {
        userRepository.save(user);
    }

    @LogExecutionTime
    public ArrayList<User> getAll() {
        return new ArrayList<User>(userRepository.findAll());
    }

    public void delete (long id) {
        userRepository.deleteById(id);
    }
}
