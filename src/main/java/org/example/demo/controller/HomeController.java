package org.example.demo.controller;

import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;

@WebServlet("/home")
public class HomeController extends HttpServlet {
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException, IOException {
        System.out.println("RUN");
        RequestDispatcher rd = request.getRequestDispatcher("/views/home.jsp");
        rd.forward(request, response);
    }
}
