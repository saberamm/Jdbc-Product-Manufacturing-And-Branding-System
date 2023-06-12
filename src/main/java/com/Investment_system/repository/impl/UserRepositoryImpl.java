package com.Investment_system.repository.impl;

import com.Investment_system.model.User;
import com.Investment_system.repository.UserRepository;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class UserRepositoryImpl implements UserRepository {
    Connection connection;

    public UserRepositoryImpl(Connection connection) {
        this.connection = connection;
    }

    @Override
    public void add(User user) {
        String sql = "INSERT INTO user_table (name , user_name , email,password) VALUES (? , ? , ? , ?) ";
        try {
            PreparedStatement prs = connection.prepareStatement
                    (sql);

            prs.setString(1, user.getName());
            prs.setString(2, user.getUser_name());
            prs.setString(3, user.getEmail());
            prs.setString(4, user.getPassword());

            prs.execute();
            prs.close();

        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    @Override
    public boolean isUserNameAvailable(String username) {
        try {
            PreparedStatement prs = connection.prepareStatement
                    ("SELECT user_name FROM user_table WHERE user_name = ?");
            prs.setString(1, username);
            ResultSet resultSet = prs.executeQuery();
            if (resultSet.next()) {
                return false;
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }
        return true;
    }

    @Override
    public boolean isEmailAvailable(String email) {
        try {
            PreparedStatement prs = connection.prepareStatement
                    ("SELECT email FROM user_table WHERE email = ?");
            prs.setString(1, email);
            ResultSet resultSet = prs.executeQuery();
            if (resultSet.next()) {
                return false;
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }
        return true;
    }

    @Override
    public void delete(long userId) {
        try {

            PreparedStatement prs = connection.prepareStatement
                    ("DELETE FROM user_table WHERE user_id = ? ");

            prs.setLong(1, userId);

            prs.execute();
            prs.close();

        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    @Override
    public User userAuthentication(String email, String password) {
        User toBePassedUser = new User();
        try {
            PreparedStatement prs = connection.prepareStatement
                    ("SELECT * FROM user_table WHERE email = ? ");

            prs.setString(1, email);

            ResultSet resultSet = prs.executeQuery();
            if (resultSet.next()) {
                if (email.equals(resultSet.getString("email")) &&
                        password.equals(resultSet.getString("password"))) {

                    toBePassedUser.setUser_id(resultSet.getInt(1));
                    toBePassedUser.setName(resultSet.getString(2));
                    toBePassedUser.setUser_name(resultSet.getString(3));
                    toBePassedUser.setEmail(resultSet.getString(4));
                    toBePassedUser.setPassword(resultSet.getString(5));

                    return toBePassedUser;
                }
            }
            prs.close();

        } catch (SQLException e) {
            e.printStackTrace();
        }
        return toBePassedUser;
    }
}
