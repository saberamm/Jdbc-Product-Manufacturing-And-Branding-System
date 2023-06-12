package com.Investment_system.service;

import com.Investment_system.model.User;

public interface UserService {
    void add(User user);

    boolean isUserNameAvailabile(String username);

    boolean isEmailAvailabile(String email);

    void delete(long userId);


    User userAuthentication(String email, String password);

}
