package com.Investment_system.service.impl;

import com.Investment_system.model.User;
import com.Investment_system.repository.UserRepository;
import com.Investment_system.service.UserService;
import com.Investment_system.ui.Menu;
import com.Investment_system.util.SecurityContext;

public class UserServiceImpl implements UserService {
    UserRepository userRepository;

    public UserServiceImpl(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    @Override
    public void add(User user) {
        if (isUserNameExist(user.getUser_name())) {
            System.out.println("Error : User Name is NOT Available!");
        }
        if (isEmailExist(user.getEmail())) {
            System.out.println("Error : Email is NOT Available!");
        } else {
            userRepository.add(user);
            SecurityContext.access=true;
        }
        if (SecurityContext.access) Menu.editMenu();
        else Menu.run();
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
