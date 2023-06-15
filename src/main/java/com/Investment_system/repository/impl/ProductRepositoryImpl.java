package com.Investment_system.repository.impl;

import com.Investment_system.model.Product;
import com.Investment_system.repository.ProductRepository;

import java.sql.*;

public class ProductRepositoryImpl implements ProductRepository {
    Connection connection;
    public ProductRepositoryImpl(Connection connection) {
        this.connection = connection;
    }
    @Override
    public void add(Product product) {
        String sql = "INSERT INTO product (name , create_date,category_id,brand_id) VALUES (? , ? , ? , ?) ";
        try {
            PreparedStatement prs = connection.prepareStatement
                    (sql, Statement.RETURN_GENERATED_KEYS);

            prs.setString(1, product.getName());
            prs.setDate(2, product.getCreate_date());
            prs.setInt(3, product.getCategory_id());
            prs.setInt(4, product.getBrand_id());
            prs.execute();
            ResultSet resultSet = prs.getGeneratedKeys();
            resultSet.next();
            product.setId(resultSet.getInt(1));
            prs.close();

        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    @Override
    public void delete(int id) {
        try {

            PreparedStatement prs = connection.prepareStatement
                    ("DELETE FROM product WHERE product_id = ? ");

            prs.setLong(1, id);

            prs.execute();
            prs.close();

        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    @Override
    public void update(Product product, int id) {
        try {
            PreparedStatement prs = connection.prepareStatement("update product set name = ?,create_date =?,category_id =?,brand_id =? where product_id = ? ");
            prs.setString(1, product.getName());
            prs.setDate(2, product.getCreate_date());
            prs.setInt(3,product.getCategory_id());
            prs.setInt(4,product.getBrand_id());
            prs.setInt(5,id);
            prs.executeUpdate();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }
}
