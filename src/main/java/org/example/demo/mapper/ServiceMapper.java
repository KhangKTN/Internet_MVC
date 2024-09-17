package org.example.demo.mapper;

import org.example.demo.modal.Customer;
import org.example.demo.modal.Service;

import java.sql.ResultSet;
import java.sql.SQLException;

public class ServiceMapper implements RowMapper<Service> {
    @Override
    public Service mapRow(ResultSet rs) {
        try {
            Service service = new Service();
            service.setId(rs.getLong("serviceId"));
            service.setName(rs.getString("name"));
            service.setUnit(rs.getString("unit"));
            service.setPrice(rs.getInt("price"));
            return service;
        } catch (SQLException e) {
            return null;
        }
    }
}
