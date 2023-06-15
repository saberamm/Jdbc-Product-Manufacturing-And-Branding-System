package com.Investment_system.repository.impl;

import com.Investment_system.repository.ShareHolderBrandRepository;

import java.sql.*;

public class ShareHolderBrandRepositoryImpl implements ShareHolderBrandRepository {
    Connection connection;

    public ShareHolderBrandRepositoryImpl(Connection connection) {
        this.connection = connection;
    }

    @Override
    public void add(int shareholderID, int brandId) {
        String sql = "INSERT INTO shareholder_brand (shareholder_id , brand_id) VALUES (? , ?) ";
        try {
            PreparedStatement prs = connection.prepareStatement
                    (sql);

            prs.setInt(1, shareholderID);
            prs.setInt(2, brandId);
            prs.execute();
            prs.close();

        } catch (SQLException e) {
            if (e.getSQLState().equals("23505"))
                System.out.println("*****the shareholder national code already exist*****");
            if (e.getSQLState().equals("23503"))
                System.out.println("*****the share holder used for a foreign key *****");
            else e.printStackTrace();
        }
    }

    @Override
    public void delete(int id) {
        try {

            PreparedStatement prs = connection.prepareStatement
                    ("DELETE FROM shareholder_brand WHERE stock_id = ? ");

            prs.setLong(1, id);

            prs.execute();
            prs.close();

        } catch (SQLException e) {
            if (e.getSQLState().equals("23505"))
                System.out.println("*****the shareholder national code already exist*****");
            if (e.getSQLState().equals("23503"))
                System.out.println("*****the share holder used for a foreign key *****");
            else e.printStackTrace();
        }
    }
}
