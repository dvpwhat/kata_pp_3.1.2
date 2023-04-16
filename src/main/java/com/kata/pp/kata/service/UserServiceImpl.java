package com.kata.pp.kata.service;



import com.kata.pp.kata.model.User;
import com.kata.pp.kata.userDAO.UserDao;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public class UserServiceImpl implements UserService {

    private final UserDao userDAO;

    public UserServiceImpl(UserDao userDAO) {
        this.userDAO = userDAO;
    }

    @Override
    public void createUser(User user) {
        userDAO.createUser(user);
    }

    @Override
    public void deleteUser(int id) {
        userDAO.deleteUser(id);
    }


    @Override
    public void updateUser(User user) {
        userDAO.updateUser(user);
    }

    @Override
    public User showUserById(int id) {
       return userDAO.showUserById(id);
    }

    @Override
    public List<User> getAllUsers() {
        return userDAO.getAllUsers();
    }



}
