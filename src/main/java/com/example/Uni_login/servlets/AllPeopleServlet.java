package com.example.Uni_login.servlets;

import com.example.Uni_login.Repository;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;

@WebServlet(name = "AllPeopleServlet", value = "/AllPeople")
public class AllPeopleServlet extends HttpServlet {
    @Override
    public void init() throws ServletException {
        super.init();

    }

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.setAttribute("users", Repository.getInstance());
        request.getRequestDispatcher("/AllPeople.jsp").forward(request,response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) {

    }
}
