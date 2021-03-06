package com.lanzdev.servlets.actions.addition;

import com.lanzdev.classes.DB;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

public class AddBand extends HttpServlet {
    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        DB     db      = DB.getDB();
        String name    = req.getParameter("name");
        String history = req.getParameter("history");
        if (db.insertBand(name, history))
            getServletContext().getRequestDispatcher("/jsp/adminPanel/bandsPanel.jsp").
                    forward(req, resp);
        else {
            req.setAttribute("response", false);
            req.setAttribute("name", name);
            req.setAttribute("history", history);
            getServletContext().getRequestDispatcher("/jsp/creators/bandCreator.jsp").
                    forward(req, resp);
        }
    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        getServletContext().getRequestDispatcher("/jsp/creators/bandCreator.jsp").
                forward(req, resp);
    }
}
