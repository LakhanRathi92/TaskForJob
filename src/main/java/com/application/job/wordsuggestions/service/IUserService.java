package com.application.job.wordsuggestions.service;

import com.application.job.wordsuggestions.models.User;

import java.util.List;

public interface IUserService {
    List<User> getAllUsers();
    User getUserById(long userId);
    void updateUser(User user);
    void deleteUser(int userId);
    boolean addUser(User user);
}
