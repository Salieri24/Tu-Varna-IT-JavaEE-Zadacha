package com.example.Uni_login.servlets;

import com.example.Uni_login.Repository;
import com.example.Uni_login.Validation;
import com.example.Uni_login.models.User;
import com.example.Uni_login.models.Users;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;

@WebServlet(name = "LoginServlet", value = "/LoginServlet")
public class LoginServlet extends HttpServlet {
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

        //check for account and then redirect.
        Users users = usersRep.getUsers();

        String username = request.getParameter("username");
        String password = request.getParameter("password");

        try {
            if (!Validation.checkUsername(username)) {
                throw new Exception("Username must be valid");
            }

            if (!Validation.checkPassword(password)) {
                throw new Exception("Password must be valid");
            }


        User user = new User("",username,password);

        if(users.checkForUser(user)!=null) {
            HttpSession session = request.getSession();
            session.setAttribute("User", user);
            response.sendRedirect(request.getContextPath() + "/dashboard.jsp");
        }
        else {
            throw new Exception("Username or Password are incorrect");
        }
        } catch (Exception e)
        {
            HttpSession session = request.getSession();
            session.setAttribute("error","Error: "+e.getMessage());

            response.sendRedirect(request.getContextPath() +"/login.jsp");
        }
    }


}
