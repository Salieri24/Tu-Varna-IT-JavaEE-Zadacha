package com.example.Uni_login.servlets;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;

@WebServlet(name = "ProfileServlet", value = "/ProfileServlet")
public class ProfileServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        if(request.getParameter("turnedOff") != null) {
            Cookie c = new Cookie("firstLoginPerDay", "");
            c.setMaxAge(60 * 60 * 24);
            response.addCookie(c);
        }
        request.getRequestDispatcher(request.getContextPath()+"/Dashboard").forward(request,response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }
}
