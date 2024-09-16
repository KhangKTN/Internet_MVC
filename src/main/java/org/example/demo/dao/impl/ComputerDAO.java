package org.example.demo.dao.impl;

import org.example.demo.dao.AbstractDAO;
import org.example.demo.mapper.ComputerMapper;
import org.example.demo.modal.Computer;
import org.example.demo.paging.Pageble;

import java.util.List;

public class ComputerDAO extends AbstractDAO<Computer> {

    public Long save(Computer computer) {
        StringBuilder sql = new StringBuilder("INSERT INTO Computer (position, status)");
        sql.append(" VALUES(?, ?)");
        return insert(sql.toString(), computer.getPosition(), computer.getStatus());
    }

    public List<Computer> findAll(Pageble pageble) {
        StringBuilder sql = new StringBuilder("SELECT * FROM Computer");
//        if (pageble.getSorter() != null && StringUtils.isNotBlank(pageble.getSorter().getSortName()) && StringUtils.isNotBlank(pageble.getSorter().getSortBy())) {
//            sql.append(" ORDER BY "+pageble.getSorter().getSortName()+" "+pageble.getSorter().getSortBy()+"");
//        }
        if (pageble.getOffset() != null && pageble.getLimit() != null) {
            sql.append(" LIMIT "+pageble.getOffset()+", "+pageble.getLimit()+"");
        }
        return query(sql.toString(), new ComputerMapper());
    }

    public int getTotalItem() {
        String sql = "SELECT count(*) FROM Computer";
        return count(sql);
    }
}
