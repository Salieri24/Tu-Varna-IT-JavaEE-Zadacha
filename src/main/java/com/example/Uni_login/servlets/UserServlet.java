package com.example.Uni_login.servlets;

import com.example.Uni_login.Repository;
import com.example.Uni_login.Validation;
import com.example.Uni_login.models.User;
import com.example.Uni_login.models.Users;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;

@WebServlet(name = "UserServlet", value = "/UserServlet")
public class UserServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        long id = Long.parseLong(request.getParameter("id"));
        Repository repository = new Repository();
        Users users = repository.getUsers();
        User user = users.getUserById(id);
        if(user==null){
//            response.sendRedirect(request.getContextPath()+"/Dashboard");
            throw new IOException("User with this id was not found!");
        }
        else{
                request.setAttribute("user",user);
                request.getRequestDispatcher("EditProfilePage.jsp").forward(request,response);
            }
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String name = request.getParameter("name");
        String work = request.getParameter("work");
        String description = request.getParameter("description");
        String email = request.getParameter("email");
        String phone = request.getParameter("phone");
        String town = request.getParameter("town");
        String street = request.getParameter("street");

        try {
        User user = (User)request.getSession(false).getAttribute("User");
        if(user == null){ throw new Exception("user is null");}
        if(Validation.checkName(name))
        {
            Repository repository = new Repository();
            if(repository.getUsers().saveUser(user))
            {
                user.setName(name);
                user.setWorkName(work);
                user.setDescription(description);
                user.setEmail(email);
                user.setPhone(phone);
                user.setTown(town);
                user.setAddress(street);
                repository.getUsers().saveUser(user);
                request.getSession(false).setAttribute("User",user);
                response.sendRedirect(request.getContextPath()+"/Dashboard");
            }
            else{
                throw new Exception("Something went wrong");
            }
        }
        } catch (Exception e) {
            e.printStackTrace();
            doGet(request,response);
        }

    }
}
