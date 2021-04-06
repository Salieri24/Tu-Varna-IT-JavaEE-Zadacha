package com.example.Uni_login.servlets;

import com.example.Uni_login.Repository;
import com.example.Uni_login.Validation;
import com.example.Uni_login.models.User;
import com.example.Uni_login.models.Users;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;

@WebServlet(name = "RegistrationServlet", value = "/RegistrationServlet")
public class RegistrationServlet extends HttpServlet {
    private Repository usersRep;

    @Override
    public void init() throws ServletException {
        super.init();
        usersRep= new Repository();
    }

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        HttpSession session = request.getSession(false);
        Cookie cookie = null;
        for(Cookie c : request.getCookies())
        {
            if(c.getName().equals("remember")) cookie = c;
        }
        if(session!=null && cookie!=null && session.getId().equals(cookie.getValue()))
            response.sendRedirect(request.getContextPath() +"/Dashboard");
        else
        request.getRequestDispatcher("index.jsp").forward(request, response);

    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {
        String name = request.getParameter("name");
        String username = request.getParameter("username");
        String password = request.getParameter("password");
        String password2 = request.getParameter("password2");

        try {
            if (!Validation.checkName(name)) {
                throw new Exception("Name must be valid");
            }
            if (!Validation.checkUsername(username)) {
                throw new Exception("Username must be valid");
            }

            if (!Validation.checkPassword(password)) {
                throw new Exception("Password must be valid");
            }
            if (!password.equals(password2)) {
                throw new Exception("Passwords do not match!");
            }


            Users users = usersRep.getUsers();

            if(users.checkForUsername(username))
            {
                throw new Exception("The username already exists!");
            }
            else{
                User user = new User(name,username,password);
                users.addUser(user);

                response.sendRedirect(request.getContextPath() +"/Login");
            }
        } catch (Exception e)
        {
            request.setAttribute("error","Error: "+e.getMessage());

            doGet(request,response);
        }


    }


}
