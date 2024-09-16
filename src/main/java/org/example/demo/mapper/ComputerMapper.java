package org.example.demo.mapper;

import org.example.demo.modal.Computer;

import java.sql.ResultSet;
import java.sql.SQLException;

public class ComputerMapper implements RowMapper<Computer> {
    @Override
    public Computer mapRow(ResultSet rs) {
        try {
            Computer computer = new Computer();
            computer.setId(rs.getLong("computerId"));
            computer.setPosition(rs.getString("position"));
            computer.setStatus(rs.getString("status"));
            return computer;
        } catch (SQLException e) {
            return null;
        }
    }
}
