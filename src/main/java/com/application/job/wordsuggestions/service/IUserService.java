package com.application.job.wordsuggestions.service;

import com.application.job.wordsuggestions.models.User;
import com.application.job.wordsuggestions.ExceptionHandles.UserNotFoundException;
import java.util.List;

public interface IUserService {
    List<User> getAllUsers();
    User getUserById(long userId) throws UserNotFoundException;
    void updateUser(User user);
    void deleteUser(int userId) throws UserNotFoundException;
    boolean addUser(User user);
}
