package com.Investment_system.repository.impl;

import com.Investment_system.model.Brand;
import com.Investment_system.repository.BrandRepository;

import java.sql.*;

public class BrandRepositoryImpl implements BrandRepository {
    Connection connection;

    public BrandRepositoryImpl(Connection connection) {
        this.connection = connection;
    }

    @Override
    public void add(Brand brand) {
        String sql = "INSERT INTO brand (name , website , description) VALUES (? , ? , ?) ";
        try {
            PreparedStatement prs = connection.prepareStatement
                    (sql, Statement.RETURN_GENERATED_KEYS);

            prs.setString(1, brand.getName());
            prs.setString(2, brand.getWebsite());
            prs.setString(3, brand.getDescription());
            prs.execute();
            ResultSet resultSet = prs.getGeneratedKeys();
            resultSet.next();
            brand.setId(resultSet.getInt(1));
            prs.close();

        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    @Override
    public void delete(int id) {
        try {

            PreparedStatement prs = connection.prepareStatement
                    ("DELETE FROM brand WHERE brand_id = ? ");

            prs.setLong(1, id);

            prs.execute();
            prs.close();

        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    @Override
    public Brand load(int id) {
        try {
            PreparedStatement prs = connection.prepareStatement
                    ("SELECT * FROM brand WHERE brand_id = ? ");

            prs.setLong(1, id);

            ResultSet resultSet = prs.executeQuery();
            if (!resultSet.next())
                return null;
            return new Brand(
                    resultSet.getInt(1),
                    resultSet.getString(2),
                    resultSet.getString(3),
                    resultSet.getString(4)
            );

        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    @Override
    public Brand[] loadAll() {
        try {
            Brand[] brandList = new Brand[rowCounter()];
            PreparedStatement prs = connection.prepareStatement("select * from brand");
            ResultSet resultSet = prs.executeQuery();
            connection.close();
            int counter = 0;
            while (resultSet.next()) {
                brandList[counter] = new Brand(
                        resultSet.getInt(1),
                        resultSet.getString(2),
                        resultSet.getString(3),
                        resultSet.getString(4)
                );
                counter++;
            }
            return brandList;
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    @Override
    public int rowCounter() {
        try {
            PreparedStatement prs = connection.prepareStatement
                    ("SELECT count(*) as rc FROM brand ");
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
    public void update(Brand brand, int id) {
        try {
            PreparedStatement prs = connection.prepareStatement("update brand set name = ?, website = ?,description =? where brand_id = ? ");
            prs.setString(1, brand.getName());
            prs.setString(2, brand.getWebsite());
            prs.setString(3, brand.getDescription());
            prs.setInt(4,id);
            prs.executeUpdate();
            connection.close();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    @Override
    public boolean isBrandExist(String name) {
        try {
            PreparedStatement prs = connection.prepareStatement
                    ("SELECT name FROM brand WHERE name = ?");
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
    public boolean isAnyBrandExist() {
        try {
            PreparedStatement prs = connection.prepareStatement
                    ("SELECT * FROM brand");
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
