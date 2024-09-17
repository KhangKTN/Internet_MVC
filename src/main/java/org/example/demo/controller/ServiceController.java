package org.example.demo.controller;

import com.fasterxml.jackson.databind.ObjectMapper;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import org.example.demo.dao.impl.ServiceDAO;
import org.example.demo.modal.Customer;
import org.example.demo.modal.Service;
import org.example.demo.utils.HttpUtil;

import java.io.IOException;

@WebServlet("/service")
public class ServiceController extends HttpServlet {
    ServiceDAO serviceDAO;

    @Override
    public void init() throws ServletException {
        serviceDAO = new ServiceDAO();
    }

    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        req.getRequestDispatcher("views/service/save.jsp").forward(req, resp);
    }

    public void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        System.out.println("POST");
        ObjectMapper mapper = new ObjectMapper();
        request.setCharacterEncoding("UTF-8");
        response.setContentType("application/json");
        Service service = HttpUtil.of(request.getReader()).toModel(Service.class);
        Long id = serviceDAO.save(service);
        mapper.writeValue(response.getOutputStream(), id);
    }

    public void doPut(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        System.out.println("PUT");
    }
}
