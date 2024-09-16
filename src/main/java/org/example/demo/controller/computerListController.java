package org.example.demo.controller;

import jakarta.servlet.http.HttpServlet;
import org.example.demo.dao.impl.ComputerDAO;
import org.example.demo.modal.Computer;
import org.example.demo.paging.PageRequest;
import org.example.demo.paging.Pageble;
import org.example.demo.utils.FormUtil;

import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.*;
import jakarta.servlet.annotation.*;
import java.io.IOException;

@WebServlet(value = "/listComputer")
public class computerListController extends HttpServlet {
    ComputerDAO computerDAO;

    public void init(){
        computerDAO = new ComputerDAO();
    }

    public void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException, IOException {
        Computer model = FormUtil.toModel(Computer.class, request);
        String view = "";
        if (model.getType().equals("list")) {
            Pageble pageble = new PageRequest(model.getPage(), model.getMaxPageItem());
            model.setListResult(computerDAO.findAll(pageble));
            model.setTotalItem(computerDAO.getTotalItem());
            model.setTotalPage((int) Math.ceil((double) model.getTotalItem() / model.getMaxPageItem()));
            view = "/views/computer/list.jsp";
        }
//        MessageUtil.showMessage(request);
        request.setAttribute("model", model);
        RequestDispatcher rd = request.getRequestDispatcher(view);
        rd.forward(request, response);
    }
}
