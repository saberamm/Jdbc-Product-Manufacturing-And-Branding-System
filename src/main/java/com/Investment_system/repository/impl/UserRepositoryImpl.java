package com.Investment_system.repository.impl;

import com.Investment_system.model.User;
import com.Investment_system.repository.UserRepository;

import java.sql.Connection;

public class UserRepositoryImpl implements UserRepository {
    Connection connection;

    public UserRepositoryImpl(Connection connection) {
        this.connection = connection;
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
