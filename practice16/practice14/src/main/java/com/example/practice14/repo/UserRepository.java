package com.example.practice14.repo;

import com.example.practice14.models.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;

@Repository
public interface UserRepository extends JpaRepository<User, Long> {

//    private List<User> users;
//
//    @Autowired
//    public UserRepository() {
//        users = new ArrayList<User>();
//    }
//
//    public void addUser(User user) {
//        users.add(user);
//    }
//
//    public void removeUser(User user) {
//        users.remove(user);
//    }
//
//    public void removeUser(int index) {
//        users.remove(index);
//    }
//
//    public List<User> getUsers() {
//        return  users;
//    }

}
