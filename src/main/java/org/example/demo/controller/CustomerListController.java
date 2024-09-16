package org.example.demo.controller;

import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import org.example.demo.dao.impl.ComputerDAO;
import org.example.demo.dao.impl.CustomerDAO;
import org.example.demo.modal.Computer;
import org.example.demo.modal.Customer;
import org.example.demo.paging.PageRequest;
import org.example.demo.paging.Pageble;
import org.example.demo.utils.FormUtil;

import java.io.IOException;

@WebServlet("/listCustomer")
public class CustomerListController extends HttpServlet {
    CustomerDAO customerDAO;

    public void init(){
        customerDAO = new CustomerDAO();
    }

    public void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException, IOException {
        Customer model = FormUtil.toModel(Customer.class, request);
        String view = "";
        if (model.getType().equals("list")) {
            Pageble pageble = new PageRequest(model.getPage(), model.getMaxPageItem());
            model.setListResult(customerDAO.findAll(pageble));
            model.setTotalItem(customerDAO.getTotalItem());
            model.setTotalPage((int) Math.ceil((double) model.getTotalItem() / model.getMaxPageItem()));
            view = "/views/customer/list.jsp";
        } else if (model.getType().equals("edit")) {
            if (model.getId() != null) {
                model = customerDAO.findOne(model.getId());
            }
            view = "/views/customer/save.jsp";
        }
//        MessageUtil.showMessage(request);
        request.setAttribute("model", model);
        RequestDispatcher rd = request.getRequestDispatcher(view);
        rd.forward(request, response);
    }
}
