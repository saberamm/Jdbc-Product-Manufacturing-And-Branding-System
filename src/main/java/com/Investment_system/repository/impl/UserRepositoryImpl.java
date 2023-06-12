package com.Investment_system.repository.impl;

import com.Investment_system.repository.UserRepository;

import java.sql.Connection;

public class UserRepositoryImpl implements UserRepository {
    Connection connection;

    public UserRepositoryImpl(Connection connection) {
        this.connection = connection;
    }
}
