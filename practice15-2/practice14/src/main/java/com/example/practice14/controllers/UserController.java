package com.example.practice14.controllers;

import com.example.practice14.models.User;
import com.example.practice14.repo.UserRepository;
import com.example.practice14.services.PostService;
import com.example.practice14.services.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.text.ParseException;
import java.util.List;

@RestController
public class UserController {

//    UserRepository userRepository;
    @Autowired
    UserService userService;

    @GetMapping(value = "/getUsers", produces = "application/json")
    public List getUsers() {
        return userService.getAll();
    }

//    test (http://localhost:8080/addUser?firstName=Alexis&lastName=Pro&middleName=Vas&birthDate=2001-09-21)
//    test2 (http://localhost:8080/addUser?firstName=Alexis&lastName=Pro&middleName=Vas&birthDate=2005-09-21)
    @GetMapping(value = "/addUser")
    public String addUser(@RequestParam String firstName,@RequestParam String lastName,@RequestParam String middleName,
                          @RequestParam String birthDate) throws ParseException {
        userService.save(new User(firstName,lastName,middleName,birthDate));
        return "ok";
    }

    @GetMapping(value = "/deleteUser")
    public String deleteUser(@RequestParam int index) {
        userService.delete(index);
        return "ok";
    }


}
