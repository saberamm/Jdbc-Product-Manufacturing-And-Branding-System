package com.Investment_system.repository;

import com.Investment_system.model.User;

public interface UserRepository {

    void add(User user);

    boolean isUserNameExist(String username);

    boolean isEmailExist(String email);

    void delete(long userId);


    User userAuthentication(String email, String password);
}
