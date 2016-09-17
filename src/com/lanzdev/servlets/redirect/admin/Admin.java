package com.lanzdev.servlets.redirect.admin;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

public class Admin extends HttpServlet {
    private static final String LOGIN    = "admin";
    private static final String PASSWORD = "admin";

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        getServletContext().getRequestDispatcher("/admin.jsp").
                forward(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String login    = req.getParameter("login");
        String password = req.getParameter("password");

        if (login.equals(LOGIN) && password.equals(PASSWORD))
            getServletContext().getRequestDispatcher("/jsp/adminPanel/genresPanel.jsp").
                    forward(req, resp);
        else
            getServletContext().getRequestDispatcher("/admin.jsp").
                    forward(req, resp);
    }
}
