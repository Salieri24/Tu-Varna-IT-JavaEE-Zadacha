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
    protected void doGet(HttpServletRequest request, HttpServletResponse response) {

    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws IOException {

//      create account and redirect
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

                HttpSession session = request.getSession();
                session.setAttribute("error","Your account has been created! Now, please log in!");

                response.sendRedirect(request.getContextPath() +"/login.jsp");
            }
        } catch (Exception e)
        {
            HttpSession session = request.getSession();
            session.setAttribute("error","Error: "+e.getMessage());

            response.sendRedirect(request.getContextPath() +"/index.jsp");

        }


    }


}
