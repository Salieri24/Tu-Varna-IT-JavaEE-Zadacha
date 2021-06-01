package com.example.Uni_login.filters;

import com.example.Uni_login.models.User;

import javax.servlet.*;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebFilter(description = "Allow users to edit only their profile page")
public class EditFilter implements Filter {
    public void init(FilterConfig config) {
    }

    public void destroy() {
    }

    @Override
    public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws ServletException, IOException {
        HttpServletRequest req = (HttpServletRequest) request;
        HttpServletResponse res = (HttpServletResponse) response;

        User user = (User) req.getSession(false).getAttribute("User");
        long id = Long.parseLong(req.getParameter("id"));

        if(user.getId() == id){
                chain.doFilter(request, response);
        }
        else res.sendRedirect(req.getContextPath() +"/Dashboard?id="+id);

    }
}
