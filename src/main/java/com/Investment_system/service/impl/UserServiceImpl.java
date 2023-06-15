package com.Investment_system.service.impl;

import com.Investment_system.model.User;
import com.Investment_system.repository.UserRepository;
import com.Investment_system.service.UserService;
import com.Investment_system.ui.menus.UserMenu;

public class UserServiceImpl implements UserService {
    UserRepository userRepository;

    public UserServiceImpl(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    @Override
    public void add(User user) {
       userRepository.add(user);
    }

    @Override
    public boolean isUserNameExist(String username) {
        return userRepository.isUserNameExist(username);
    }

    @Override
    public boolean isEmailExist(String email) {
        return userRepository.isEmailExist(email);
    }

    @Override
    public void delete(long userId) {
        userRepository.delete(userId);
    }


    @Override
    public User userAuthentication(String user_name, String password) {
        return userRepository.userAuthentication(user_name, password);
    }
}
