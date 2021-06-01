package com.example.Uni_login.servlets;

import com.example.Uni_login.Repository;
import com.example.Uni_login.models.User;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;

@WebServlet(name = "ProfileServlet", urlPatterns = {"/Dashboard", "/ProfileServlet"})
public class ProfileServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        long id = Long.parseLong(request.getParameter("id"));
        User user = Repository.getInstance().getUsers().getUserById(id);
        request.setAttribute("User",user);
        request.getRequestDispatcher("dashboard.jsp").forward(request,response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        if(request.getParameter("turnedOff") != null) {
            Cookie c = new Cookie("firstLoginPerDay", "");
            c.setMaxAge(60 * 60 * 24);
            response.addCookie(c);
        }
        doGet(request,response);
    }
}
