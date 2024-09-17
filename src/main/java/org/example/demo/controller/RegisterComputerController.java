package org.example.demo.controller;

import com.fasterxml.jackson.databind.ObjectMapper;
import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import org.example.demo.dao.impl.ComputerDAO;
import org.example.demo.dao.impl.CustomerDAO;
import org.example.demo.dao.impl.RegisterComputerDAO;
import org.example.demo.modal.Computer;
import org.example.demo.modal.UsingComputer;
import org.example.demo.utils.HttpUtil;

import java.io.IOException;

@WebServlet("/register-computer")
public class RegisterComputerController extends HttpServlet {
    CustomerDAO customerDAO;
    ComputerDAO computerDAO;
    RegisterComputerDAO registerComputerDAO;

    public void init() throws ServletException {
        customerDAO = new CustomerDAO();
        computerDAO = new ComputerDAO();
        registerComputerDAO = new RegisterComputerDAO();
    }

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        ObjectMapper mapper = new ObjectMapper();
        request.setCharacterEncoding("UTF-8");
        response.setContentType("application/json");
        UsingComputer usingComputer = HttpUtil.of(request.getReader()).toModel(UsingComputer.class);
        System.out.println(request.getReader().readLine());
        boolean isSuccess = registerComputerDAO.save(usingComputer);
        mapper.writeValue(response.getOutputStream(), isSuccess);
    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        req.setAttribute("customerList", customerDAO.findAll());
        req.setAttribute("computerList", computerDAO.findAll());
        req.getRequestDispatcher("/views/registerComputer/save.jsp").forward(req, resp);
    }
}
