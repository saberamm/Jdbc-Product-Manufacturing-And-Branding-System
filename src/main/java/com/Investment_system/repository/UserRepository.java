package com.Investment_system.repository;

import com.Investment_system.model.User;

public interface UserRepository {

    void add(User user);

    boolean isUserNameAvailabile(String username);

    boolean isEmailAvailabile(String email);

    void delete(long userId);


    User userAuthentication(String email, String password);
}
