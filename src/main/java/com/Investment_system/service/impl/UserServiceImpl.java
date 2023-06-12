package com.Investment_system.service.impl;

import com.Investment_system.model.User;
import com.Investment_system.repository.UserRepository;
import com.Investment_system.service.UserService;

public class UserServiceImpl implements UserService {
    UserRepository userRepository;

    public UserServiceImpl(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    @Override
    public void add(User user) {


    }

    @Override
    public boolean isUserNameAvailabile(String username) {
        return false;
    }

    @Override
    public boolean isEmailAvailabile(String email) {
        return false;
    }

    @Override
    public void delete(long userId) {

    }


    @Override
    public User userAuthentication(String email, String password) {
        return null;
    }
}
