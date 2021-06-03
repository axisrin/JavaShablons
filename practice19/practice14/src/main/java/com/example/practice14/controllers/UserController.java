package com.example.practice14.controllers;

import com.example.practice14.dto.FilterUsersDTO;
import com.example.practice14.models.User;
import com.example.practice14.repo.UserRepository;
import com.example.practice14.services.PostService;
import com.example.practice14.services.UserFilterService;
import com.example.practice14.services.UserService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.sql.Date;
import java.text.ParseException;
import java.util.List;

@RestController
public class UserController {

//    UserRepository userRepository;
    public static final Logger LOGGER = LoggerFactory.getLogger(UserController.class);


    @Autowired
    UserService userService;
    @Autowired
    UserFilterService userFilterService;

    @GetMapping(value = "/getUsers", produces = "application/json")
    public List getUsers() {
        LOGGER.info("This is getUsers infoLog");
        return userService.getAll();
    }

//    test (http://localhost:8080/addUser?firstName=Alexis&lastName=Pro&middleName=Vas&birthDate=2001-09-21)
//    test2 (http://localhost:8080/addUser?firstName=Alexis&lastName=Pro&middleName=Vas&birthDate=2005-09-21)
//    test3 (http://localhost:8080/addUser?firstName=Stas&lastName=Prosto&middleName=Ai&birthDate=2001-09-21)
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

    @RequestMapping(value = "users/filter", method = RequestMethod.POST)
    @ResponseBody
    public  List<User> filter(@RequestParam String firstName, @RequestParam String lastName, @RequestParam String middleName
            , @RequestParam Date birthDate){
        System.out.println(1);
        return userFilterService.findUsersByFirstNameAndLastNameAndMiddleNameAndBirthDate(
                firstName,
                lastName,
                middleName,
                birthDate);
                //http://localhost:8080/users/filter?firstName=Stas&lastName=Prosto&middleName=Ai&birthDate=2001-09-01
    }


}
