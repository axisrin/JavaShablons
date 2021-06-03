package com.example.practice14.services;

import com.example.practice14.dao.UserDAO;
import com.example.practice14.models.Post;
import com.example.practice14.models.User;

import java.util.List;

public class UserService {

    private UserDAO usersDAO = new UserDAO();

    public UserService() {}

    public User findUser(Long id) {
        return usersDAO.findById(id);
    }

    public void saveUser(User user) {
        usersDAO.save(user);
    }

    public void deleteUser(User user) {
        usersDAO.delete(user);
    }

    public void updateUser(User user) {
        usersDAO.update(user);
    }

    public List<User> findAllUsers() {
        return usersDAO.findAll();
    }

    public Post findPostByID(Long id) {
        return usersDAO.findPostById(id);
    }

}
