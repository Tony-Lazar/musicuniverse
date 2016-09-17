package com.lanzdev.servlets.actions.update;

import com.lanzdev.classes.DB;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

public class UpdateSubgenre extends HttpServlet {
    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String reqHeader = req.getHeader("Referer").substring(req.getHeader("Referer").lastIndexOf('/') + 1);
        System.out.println(reqHeader);
        if (reqHeader.equals("updateSubgenre")) {
            int    id      = Integer.parseInt(req.getParameter("id"));
            int    parent  = Integer.parseInt(req.getParameter("parent"));
            String name    = req.getParameter("name");
            String history = req.getParameter("history");
            req.setAttribute("response", DB.getDB().updateSubgenre(id, parent, name, history));
        }

        getServletContext().getRequestDispatcher("/jsp/editors/subgenreEditor.jsp").
                forward(req, resp);
    }
}
