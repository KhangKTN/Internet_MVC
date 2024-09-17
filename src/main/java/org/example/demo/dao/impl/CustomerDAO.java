package org.example.demo.dao.impl;

import org.example.demo.dao.AbstractDAO;
import org.example.demo.mapper.ComputerMapper;
import org.example.demo.mapper.CustomerMapper;
import org.example.demo.modal.Computer;
import org.example.demo.modal.Customer;
import org.example.demo.paging.Pageble;

import java.util.List;

public class CustomerDAO extends AbstractDAO<Customer> {
    public Long save(Customer customer) {
        StringBuilder sql = new StringBuilder("INSERT INTO Customer (name, address, phone, email)");
        sql.append(" VALUES(?, ?, ?, ?)");
        return insert(sql.toString(), customer.getName(), customer.getAddress(), customer.getPhone(), customer.getEmail());
    }

    public List<Customer> findAll(){
        String sql = new String("SELECT * FROM Customer");
        return query(sql, new CustomerMapper());
    }

    public List<Customer> findAll(Pageble pageble) {
        StringBuilder sql = new StringBuilder("SELECT * FROM Customer");
//        if (pageble.getSorter() != null && StringUtils.isNotBlank(pageble.getSorter().getSortName()) && StringUtils.isNotBlank(pageble.getSorter().getSortBy())) {
//            sql.append(" ORDER BY "+pageble.getSorter().getSortName()+" "+pageble.getSorter().getSortBy()+"");
//        }
        if (pageble.getOffset() != null && pageble.getLimit() != null) {
            sql.append(" LIMIT "+pageble.getOffset()+", "+pageble.getLimit()+"");
        }
        return query(sql.toString(), new CustomerMapper());
    }

    public Customer findOne(Long id) {
        String sql = "SELECT * FROM Customer WHERE customerId = ?";
        List<Customer> customerList = query(sql, new CustomerMapper(), id);
        return customerList.isEmpty() ? null : customerList.get(0);
    }

    public void update(Customer customer) {
        StringBuilder sql = new StringBuilder("UPDATE Customer SET name = ?, address = ?,");
        sql.append(" phone = ?");
        sql.append(" WHERE customerId = ?");
        update(sql.toString(), customer.getName(), customer.getAddress(), customer.getPhone(), customer.getId());
    }

    public int getTotalItem() {
        String sql = "SELECT count(*) FROM Customer";
        return count(sql);
    }
}
