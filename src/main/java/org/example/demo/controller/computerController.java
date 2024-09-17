package org.example.demo.controller;

import java.io.*;

import com.fasterxml.jackson.databind.ObjectMapper;
import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.*;
import jakarta.servlet.annotation.*;
import org.example.demo.dao.AbstractDAO;
import org.example.demo.dao.impl.ComputerDAO;
import org.example.demo.modal.Computer;
import org.example.demo.utils.HttpUtil;

@WebServlet(value = "/computer")
public class computerController extends HttpServlet {
    private ComputerDAO computerDAO;

    public void init() {
        computerDAO = new ComputerDAO();
    }

    public void doGet(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {
        RequestDispatcher rd = request.getRequestDispatcher("/views/computer/save.jsp");
        rd.forward(request, response);
    }

    public void doPost(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {
        ObjectMapper mapper = new ObjectMapper();
        request.setCharacterEncoding("UTF-8");
        response.setContentType("application/json");
        Computer newComputer = HttpUtil.of(request.getReader()).toModel(Computer.class);
        Long id = computerDAO.save(newComputer);
        mapper.writeValue(response.getOutputStream(), id);
    }

    public void destroy() {

    }
}