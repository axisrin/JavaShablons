package com.example.practice14.services;

import com.example.practice14.models.User;
import com.example.practice14.repo.UserRepository;
import org.hibernate.Session;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.example.practice14.services.PostService;



import java.text.ParseException;
import java.util.ArrayList;

@Service
public class UserService {
    @Autowired
    UserRepository userRepository;

    private Session sessionFactory;

    public void save(User user) throws ParseException {
        userRepository.save(user);
    }

    public ArrayList<User> getAll() {
        return new ArrayList<User>(userRepository.findAll());
    }

    public void delete (long id) {
        userRepository.deleteById(id);
    }
}
