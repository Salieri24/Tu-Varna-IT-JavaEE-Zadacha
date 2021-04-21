package com.example.Uni_login.servlets;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;

@WebServlet(name = "LogoutServlet", value = "/Logout")
public class LogoutServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws IOException {
        for(Cookie c : request.getCookies())
        {
            if(c.getName().equals("remember"))
            {
                c.setMaxAge(0);
                response.addCookie(c);
            }
        }
        request.getSession().invalidate();
        response.sendRedirect(request.getContextPath()+"/Login");
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) {

    }
}
