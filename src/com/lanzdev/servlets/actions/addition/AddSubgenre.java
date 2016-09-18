package com.lanzdev.servlets.actions.addition;

import com.lanzdev.classes.DB;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

public class AddSubgenre extends HttpServlet {
    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        DB     db      = DB.getDB();
        int    parent  = Integer.parseInt(req.getParameter("parent"));
        String name    = req.getParameter("name");
        String history = req.getParameter("history");

        if (db.insertSubgenre(parent, name, history))
            getServletContext().getRequestDispatcher("/jsp/adminPanel/subgenresPanel.jsp").
                    forward(req, resp);
        else {
            req.setAttribute("response", false);
            req.setAttribute("parent", parent);
            req.setAttribute("name", name);
            req.setAttribute("history", history);
            getServletContext().getRequestDispatcher("/jsp/creators/subgenreCreator.jsp").
                    forward(req, resp);
        }
    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        getServletContext().getRequestDispatcher("/jsp/creators/subgenreCreator.jsp").
                forward(req, resp);
    }
}
