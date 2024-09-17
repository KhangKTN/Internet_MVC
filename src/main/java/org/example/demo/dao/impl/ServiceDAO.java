package org.example.demo.dao.impl;

import org.example.demo.dao.AbstractDAO;
import org.example.demo.mapper.CustomerMapper;
import org.example.demo.mapper.ServiceMapper;
import org.example.demo.modal.Customer;
import org.example.demo.modal.Service;
import org.example.demo.paging.Pageble;

import java.util.List;

public class ServiceDAO extends AbstractDAO<Service> {
    public Long save(Service service) {
        StringBuilder sql = new StringBuilder("INSERT INTO Service (name, unit, price)");
        sql.append(" VALUES(?, ?, ?)");
        return insert(sql.toString(), service.getName(), service.getUnit(), service.getPrice());
    }

    public List<Service> findAll(){
        String sql = new String("SELECT * FROM Customer");
        return query(sql, new ServiceMapper());
    }

    public List<Service> findAll(Pageble pageble) {
        StringBuilder sql = new StringBuilder("SELECT * FROM Service");
        if (pageble.getOffset() != null && pageble.getLimit() != null) {
            sql.append(" LIMIT " + pageble.getOffset() + ", " + pageble.getLimit() + "");
        }
        return query(sql.toString(), new ServiceMapper());
    }

    public Service findOne(Long id) {
        String sql = "SELECT * FROM Service WHERE serviceId = ?";
        List<Service> serviceList = query(sql, new ServiceMapper(), id);
        return serviceList.isEmpty() ? null : serviceList.get(0);
    }

    public void update(Service service) {
        StringBuilder sql = new StringBuilder("UPDATE Service SET name = ?, unit = ?, price = ?");
        sql.append(" WHERE serviceId = ?");
        update(sql.toString(), service.getName(), service.getUnit(), service.getPrice());
    }

    public int getTotalItem() {
        String sql = "SELECT count(*) FROM Service";
        return count(sql);
    }
}
