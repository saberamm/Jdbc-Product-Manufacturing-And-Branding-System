package com.Investment_system.repository.impl;

import com.Investment_system.model.Category;
import com.Investment_system.repository.CategoryRepository;

import java.sql.*;

public class CategoryRepositoryImpl implements CategoryRepository {
    Connection connection;

    public CategoryRepositoryImpl(Connection connection) {
        this.connection = connection;
    }

    @Override
    public void add(Category category) {
        String sql = "INSERT INTO category_table (name , description) VALUES (? , ?) ";
        try {
            PreparedStatement prs = connection.prepareStatement
                    (sql, Statement.RETURN_GENERATED_KEYS);

            prs.setString(1, category.getName());
            prs.setString(2, category.getDescription());
            prs.execute();
            ResultSet resultSet = prs.getGeneratedKeys();
            resultSet.next();
            category.setId(resultSet.getInt(1));
            prs.close();

        } catch (SQLException e) {
            if(e.getSQLState().equals("23505")) System.out.println("*****the category name already exist*****");
            if(e.getSQLState().equals("23503")) System.out.println("*****the category used for a foreign key *****");
            else e.printStackTrace();
        }
    }

    @Override
    public void delete(int id) {
        try {

            PreparedStatement prs = connection.prepareStatement
                    ("DELETE FROM category_table WHERE category_id = ? ");

            prs.setLong(1, id);

            prs.execute();
            prs.close();

        } catch (SQLException e) {
            if(e.getSQLState().equals("23505")) System.out.println("*****the category name already exist*****");
            if(e.getSQLState().equals("23503")) System.out.println("*****the category used for a foreign key *****");
            else e.printStackTrace();
        }
    }

    @Override
    public Category load(int id) {
        try {
            PreparedStatement prs = connection.prepareStatement
                    ("SELECT * FROM category_table WHERE category_id = ? ");

            prs.setLong(1, id);

            ResultSet resultSet = prs.executeQuery();
            if (!resultSet.next())
                return null;
            return new Category(
                    resultSet.getInt(1),
                    resultSet.getString(2),
                    resultSet.getString(3)
            );

        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    @Override
    public Category[] loadAll() {
        try {
            Category[] categoryList = new Category[rowCounter()];
            PreparedStatement prs = connection.prepareStatement("select * from category_table");
            ResultSet resultSet = prs.executeQuery();
            int counter = 0;
            while (resultSet.next()) {
                categoryList[counter] = new Category(
                        resultSet.getInt(1),
                        resultSet.getString(2),
                        resultSet.getString(3)
                );
                counter++;
            }
            return categoryList;
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    @Override
    public int rowCounter() {
        try {
            PreparedStatement prs = connection.prepareStatement
                    ("SELECT count(*) as rc FROM category_table ");
            ResultSet resultSet = prs.executeQuery();
            resultSet.next();
            int count = resultSet.getInt("rc");
            resultSet.close();
            return count;
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    @Override
    public void update(Category category, int id) {
        try {
            PreparedStatement prs = connection.prepareStatement("update category_table set name = ?,description =? where category_id = ? ");
            prs.setString(1, category.getName());
            prs.setString(2, category.getDescription());
            prs.setInt(3,id);
            prs.executeUpdate();
        } catch (SQLException e) {
            if(e.getSQLState().equals("23505")) System.out.println("*****the category name already exist*****");
            if(e.getSQLState().equals("23503")) System.out.println("*****the category used for a foreign key *****");
            else e.printStackTrace();
        }
    }

    @Override
    public boolean isCategoryExist(String name) {
        try {
            PreparedStatement prs = connection.prepareStatement
                    ("SELECT * FROM category_table WHERE name = ?");
            prs.setString(1, name);
            ResultSet resultSet = prs.executeQuery();
            if (resultSet.next()) {
                return true;
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }
        return false;
    }

    @Override
    public boolean isAnyCategoryExist() {
        try {
            PreparedStatement prs = connection.prepareStatement
                    ("SELECT * FROM category_table");
            ResultSet resultSet = prs.executeQuery();
            if (resultSet.next()) {
                return true;
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }
        return false;
    }
}
