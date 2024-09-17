package org.example.demo.controller;

import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import org.example.demo.dao.impl.ServiceDAO;
import org.example.demo.modal.Customer;
import org.example.demo.modal.Service;
import org.example.demo.paging.PageRequest;
import org.example.demo.paging.Pageble;
import org.example.demo.utils.FormUtil;

import java.io.IOException;

@WebServlet("/listService")
public class ServiceListController extends HttpServlet {
    ServiceDAO serviceDAO;

    @Override
    public void init() throws ServletException {
        serviceDAO = new ServiceDAO();
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        Service model = FormUtil.toModel(Service.class, request);
        String view = "";
        if (model.getType().equals("list")) {
            Pageble pageble = new PageRequest(model.getPage(), model.getMaxPageItem());
            model.setListResult(serviceDAO.findAll(pageble));
            model.setTotalItem(serviceDAO.getTotalItem());
            model.setTotalPage((int) Math.ceil((double) model.getTotalItem() / model.getMaxPageItem()));
            view = "/views/service/list.jsp";
        } else if (model.getType().equals("edit")) {
            if (model.getId() != null) {
                model = serviceDAO.findOne(model.getId());
            }
            view = "/views/service/save.jsp";
        }
//        MessageUtil.showMessage(request);
        request.setAttribute("model", model);
        RequestDispatcher rd = request.getRequestDispatcher(view);
        rd.forward(request, response);
    }
}
