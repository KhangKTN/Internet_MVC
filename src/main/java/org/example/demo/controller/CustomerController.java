package org.example.demo.controller;

import com.fasterxml.jackson.databind.ObjectMapper;
import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import org.example.demo.dao.AbstractDAO;
import org.example.demo.dao.impl.CustomerDAO;
import org.example.demo.modal.Computer;
import org.example.demo.modal.Customer;
import org.example.demo.utils.HttpUtil;

import java.io.IOException;

@WebServlet("/customer")
public class CustomerController extends HttpServlet {
    CustomerDAO customerDAO = new CustomerDAO();

    public void init() {
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        RequestDispatcher rd = request.getRequestDispatcher("/views/customer/save.jsp");
        rd.forward(request, response);
    }

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        ObjectMapper mapper = new ObjectMapper();
        request.setCharacterEncoding("UTF-8");
        response.setContentType("application/json");
        Customer customer = HttpUtil.of(request.getReader()).toModel(Customer.class);
        Long id = customerDAO.save(customer);
        mapper.writeValue(response.getOutputStream(), id);
    }

    protected void doPut(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        ObjectMapper mapper = new ObjectMapper();
        request.setCharacterEncoding("UTF-8");
        response.setContentType("application/json");
        Customer customer =  HttpUtil.of(request.getReader()).toModel(Customer.class);
        customerDAO.update(customer);
        mapper.writeValue(response.getOutputStream(), customer);
    }

    public void destroy() {
    }
}
