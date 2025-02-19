package com.megacity.servlet;

import com.megacity.service.UserService;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet("/login")
public class LoginServlet extends HttpServlet {

    private static final long serialVersionUID = 1L;
    private UserService userService;

    public LoginServlet() {
        super();
        userService = new UserService();
    }

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.getRequestDispatcher("/login.jsp").forward(request, response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String username = request.getParameter("username");
        String password = request.getParameter("password");

        boolean isAuthenticated = userService.authenticateUser(username, password);

        if (isAuthenticated) {
            response.sendRedirect("home.jsp"); // Redirect to a homepage on successful login
        } else {
            request.setAttribute("error", "Invalid username or password");
            request.getRequestDispatcher("/login.jsp").forward(request, response);
        }
    }
}
