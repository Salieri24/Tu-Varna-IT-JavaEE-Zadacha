package com.example.Uni_login.servlets;

import com.example.Uni_login.models.User;
import com.example.Uni_login.models.Users;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;

@WebServlet(name = "RegistrationServlet", value = "/RegistrationServlet")
public class RegistrationServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

//      create account and redirect
        String name = request.getParameter("name");
        String username = request.getParameter("username");
        String password = request.getParameter("password");

        try {
            if (!checkName(name)) {
                throw new Exception("Name must be valid");
            }
            if (!checkUsername(username)) {
                throw new Exception("Username must be valid");
            }

            if (!checkPassword(password)) {
                throw new Exception("Password must be valid");
            }
        } catch (Exception e)
        {
            e.printStackTrace();
        }

        if(checkForUser(username,password))
        {
            System.out.println("username already exists");
            // Notify the user that the username already exists
        }
        else{
            User user = new User(name,username,password);
            Users users = new Users();// actually i should load it from a database somewhere
            users.addUser(user);

            HttpSession session = request.getSession();

            session.setAttribute("User", user);

            System.out.println(session.getAttribute("User"));

            response.sendRedirect(request.getContextPath() +"/dashboard.jsp");
        }


    }

    private boolean checkPassword(String password) {

        //Todo: checks if the password meets the requirements
        return true;
    }

    private boolean checkUsername(String username) {
        //Todo: checks if the password meets the requirements
        return true;
    }

    private boolean checkName(String name) {
        //Todo: checks if the password meets the requirements
        return true;
    }

    private boolean checkForUser(String username, String password) {
        return false;
        //Todo: actually check.
    }
}
