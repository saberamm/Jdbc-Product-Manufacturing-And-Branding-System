package com.Investment_system.util;

import com.Investment_system.connection.DBConnection;
import com.Investment_system.repository.UserRepository;
import com.Investment_system.repository.impl.UserRepositoryImpl;
import com.Investment_system.service.UserService;
import com.Investment_system.service.impl.UserServiceImpl;

import java.sql.Connection;

public class ApplicationContext {
    private static Connection connection;
    private static UserRepository userRepository;
    private static UserService userService;

    public static UserService getUserService() {
        return userService;
    }

    static {
        connection = new DBConnection().getConnection();
        userRepository = new UserRepositoryImpl(connection);
        userService = new UserServiceImpl(userRepository);
    }

}
