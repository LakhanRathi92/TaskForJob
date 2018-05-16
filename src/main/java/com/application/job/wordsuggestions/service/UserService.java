package com.application.job.wordsuggestions.service;

import com.application.job.wordsuggestions.models.User;
import com.application.job.wordsuggestions.repositories.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class UserService implements IUserService{
    @Autowired
    private UserRepository userRepository;

    @Override
    public List<User> getAllUsers() {
        List<User> list = new ArrayList<>();
        userRepository.findAll().forEach(e-> list.add(e));
        return list;
    }

    @Override
    public User getUserById(long userId) {
        User res = userRepository.findById(userId).get();
        return res;
    }

    @Override
    public void updateUser(User user) {
        userRepository.save(user);
    }

    @Override
    public void deleteUser(int userId) {
        userRepository.delete(getUserById(userId));
    }

    @Override
    public synchronized boolean addUser(User user) {
        List<User> list = new ArrayList<>();
        userRepository.findAll().forEach( e-> list.add(e));
        for(User current: list) {
            if(current.getFirstName().equals(user.getFirstName()) && current.getLastName().equals(user.getLastName()))
                return false;
        }
        userRepository.save(user);
        return true;
    }
}
