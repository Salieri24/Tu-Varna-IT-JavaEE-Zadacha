package com.example.Uni_login.servlets;

import com.example.Uni_login.Repository;
import com.example.Uni_login.Validation;
import com.example.Uni_login.models.User;
import com.example.Uni_login.models.Users;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.*;
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
        request.getRequestDispatcher("login.jsp").forward(request, response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {
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
        user = users.checkForUser(user);
        if(user!=null) {
            request.getSession(false).invalidate();
            HttpSession session = request.getSession();
            session.setAttribute("User", user);

            //Cookie cookie = new Cookie("remember", session.getId());
            //response.addCookie(cookie);

//            response.sendRedirect(request.getContextPath() + "/Dashboard");
            response.sendRedirect(request.getContextPath() + "/Edit?id="+user.getId());
        }
        else {
            throw new Exception("Username or Password are incorrect");
        }
        } catch (Exception e)
        {
            request.setAttribute("error","Error: "+e.getMessage());
            doGet(request,response);
        }
    }


}
