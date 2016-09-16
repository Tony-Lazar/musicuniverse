package com.lanzdev.servlets.actions.update;

import com.lanzdev.classes.DB;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

public class UpdateGenre extends HttpServlet{
    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        int id = Integer.parseInt(req.getParameter("id"));
        String name = req.getParameter("name");
        String history = req.getParameter("history");
        req.setAttribute("response", DB.getDB().updateGenre(id, name, history));

        getServletContext().getRequestDispatcher("/jsp/editors/genreEditor.jsp").
                forward(req, resp);
    }
}
