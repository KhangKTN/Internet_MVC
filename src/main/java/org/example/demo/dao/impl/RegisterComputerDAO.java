package org.example.demo.dao.impl;

import org.example.demo.dao.AbstractDAO;
import org.example.demo.modal.UsingComputer;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class RegisterComputerDAO extends AbstractDAO<RegisterComputerDAO> {
    public boolean save(UsingComputer usingComputer) {
        String sql = "Insert into Customer_Computer (customerId, computerId, startDate, startTime) values(?,?, CURRENT_DATE, CURRENT_TIME)";
        Connection connection = null;
        PreparedStatement statement = null;
        try {
            connection = getConnection();
            connection.setAutoCommit(false);
            statement = connection.prepareStatement(sql);
            setParameter(statement, usingComputer.getCustomerId(), usingComputer.getComputerId());
            statement.executeUpdate();

            sql = "Update Computer set status = ? where computerId = ?";
            statement = connection.prepareStatement(sql);
            setParameter(statement, "Busy", usingComputer.getComputerId());
            statement.executeUpdate();
            connection.commit();
            return true;
        } catch (SQLException e) {
            if (connection != null) {
                try {
                    connection.rollback();
                } catch (SQLException e1) {
                    e1.printStackTrace();
                }
            }
            return false;
        } finally {
            try {
                if (connection != null) {
                    connection.close();
                }
                if (statement != null) {
                    statement.close();
                }
            } catch (SQLException e2) {
                e2.printStackTrace();
            }
        }
    }
}
