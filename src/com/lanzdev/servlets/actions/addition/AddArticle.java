package com.lanzdev.servlets.actions.addition;

import com.lanzdev.classes.DB;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

public class AddArticle extends HttpServlet {
    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        DB     db      = DB.getDB();
        String title   = req.getParameter("title");
        String content = req.getParameter("content");
        if (db.insertArticle(title, content))
            getServletContext().getRequestDispatcher("/jsp/adminPanel/articlesPanel.jsp").
                    forward(req, resp);
        else {
            req.setAttribute("response", false);
            req.setAttribute("title", title);
            req.setAttribute("content", content);
            System.out.println(content);
            getServletContext().getRequestDispatcher("/jsp/creators/articleCreator.jsp").
                    forward(req, resp);
        }
    }
}
