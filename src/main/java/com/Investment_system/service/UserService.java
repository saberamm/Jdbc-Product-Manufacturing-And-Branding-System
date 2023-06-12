package com.Investment_system.service;

import com.Investment_system.model.User;

public interface UserService {
    void add(User user);

    boolean isUserNameExist(String username);

    boolean isEmailExist(String email);

    void delete(long userId);


    User userAuthentication(String user_name, String password);

}
