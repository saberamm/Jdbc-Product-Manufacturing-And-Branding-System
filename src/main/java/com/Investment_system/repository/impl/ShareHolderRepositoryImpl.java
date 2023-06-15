package com.Investment_system.repository.impl;

import com.Investment_system.model.Shareholder;
import com.Investment_system.repository.ShareHolderRepository;

import java.sql.*;

public class ShareHolderRepositoryImpl implements ShareHolderRepository {
    Connection connection;

    public ShareHolderRepositoryImpl(Connection connection) {
        this.connection = connection;
    }

    @Override
    public void add(Shareholder shareholder) {
        String sql = "INSERT INTO shareholder (name , phone_number,national_code) VALUES (? , ? , ?) ";
        try {
            PreparedStatement prs = connection.prepareStatement
                    (sql, Statement.RETURN_GENERATED_KEYS);

            prs.setString(1, shareholder.getName());
            prs.setString(2, shareholder.getPhone_number());
            prs.setString(3, shareholder.getNational_code());
            prs.execute();
            ResultSet resultSet = prs.getGeneratedKeys();
            resultSet.next();
            shareholder.setId(resultSet.getInt(1));
            prs.close();

        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    @Override
    public void delete(int id) {
        try {

            PreparedStatement prs = connection.prepareStatement
                    ("DELETE FROM shareholder WHERE shareholder_id = ? ");

            prs.setLong(1, id);

            prs.execute();
            prs.close();

        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    @Override
    public Shareholder load(int id) {
        try {
            PreparedStatement prs = connection.prepareStatement
                    ("SELECT * FROM shareholder WHERE shareholder_id = ? ");

            prs.setLong(1, id);

            ResultSet resultSet = prs.executeQuery();
            if (!resultSet.next())
                return null;
            return new Shareholder(
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
    public Shareholder[] loadAll() {
        try {
            Shareholder[] shareholderList = new Shareholder[rowCounter()];
            PreparedStatement prs = connection.prepareStatement("select * from shareholder");
            ResultSet resultSet = prs.executeQuery();
            int counter = 0;
            while (resultSet.next()) {
                shareholderList[counter] = new Shareholder(
                        resultSet.getInt(1),
                        resultSet.getString(2),
                        resultSet.getString(3),
                        resultSet.getString(4)
                );
                counter++;
            }
            return shareholderList;
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    @Override
    public int rowCounter() {
        try {
            PreparedStatement prs = connection.prepareStatement
                    ("SELECT count(*) as rc FROM shareholder ");
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
    public void update(Shareholder shareholder, int id) {
        try {
            PreparedStatement prs = connection.prepareStatement("update shareholder set name = ?,phone_number=?,national_code =? where shareholder_id = ? ");
            prs.setString(1, shareholder.getName());
            prs.setString(2, shareholder.getPhone_number());
            prs.setString(3, shareholder.getNational_code());
            prs.setInt(4, id);
            prs.executeUpdate();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    @Override
    public boolean isShareholderExist(String nationalCode) {
        try {
            PreparedStatement prs = connection.prepareStatement
                    ("SELECT * FROM shareholder WHERE national_code = ?");
            prs.setString(1, nationalCode);
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
    public boolean isAnyShareholderExist() {
        try {
            PreparedStatement prs = connection.prepareStatement
                    ("SELECT * FROM shareholder");
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
