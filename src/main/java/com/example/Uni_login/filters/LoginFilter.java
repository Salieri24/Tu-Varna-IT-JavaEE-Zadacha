package com.example.Uni_login.filters;

import com.example.Uni_login.Repository;
import com.example.Uni_login.models.User;

import javax.servlet.*;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebFilter(description = "Filter all unauthorized access.")
public class LoginFilter implements Filter {
    public void init(FilterConfig config) {
    }

    public void destroy() {
    }

    @Override
    public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws ServletException, IOException {
        HttpServletRequest req = (HttpServletRequest) request;
        HttpServletResponse res = (HttpServletResponse) response;

        User user = (User) req.getSession(false).getAttribute("User");
        if(user != null && user == Repository.getInstance().getUserById(user.getId())){
                chain.doFilter(request, response);
        }
        else res.sendRedirect(req.getContextPath() +"/Login");
    }
}
