package com.lanzdev.servlets.actions.update;

import com.lanzdev.classes.DB;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

public class UpdateArticle extends HttpServlet {
    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        int id = Integer.parseInt(req.getParameter("id"));
        String title = req.getParameter("title");
        String content = req.getParameter("content");
        req.setAttribute("response", DB.getDB().updateArticle(id, title, content));

        getServletContext().getRequestDispatcher("/jsp/editors/articleEditor.jsp").
                forward(req, resp);
    }
}
