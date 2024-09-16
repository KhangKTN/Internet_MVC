package org.example.demo.mapper;

import org.example.demo.modal.Computer;
import org.example.demo.modal.Customer;

import java.sql.ResultSet;
import java.sql.SQLException;

public class CustomerMapper implements RowMapper<Customer> {
    @Override
    public Customer mapRow(ResultSet rs) {
        try {
            Customer customer = new Customer();
            customer.setId(rs.getLong("customerId"));
            customer.setName(rs.getString("name"));
            customer.setAddress(rs.getString("address"));
            customer.setPhone(rs.getString("phone"));
            customer.setEmail(rs.getString("email"));
            return customer;
        } catch (SQLException e) {
            return null;
        }
    }
}
