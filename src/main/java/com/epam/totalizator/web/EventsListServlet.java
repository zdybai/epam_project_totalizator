package com.epam.totalizator.web;


import com.epam.totalizator.core.DBManager;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;


/**
 * Created with IntelliJ IDEA.
 * User: Zdybai
 * Date: 09.12.13
 * Time: 21:35
 * To change this template use File | Settings | File Templates.
 */

@WebServlet("/events")
public class EventsListServlet extends HttpServlet {
    @Override
    public void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        DBManager manager = new DBManager();
        req.setAttribute("events", manager.GetEvents());
        req.getRequestDispatcher("/WEB-INF/views/eventsList.jsp").forward(req, resp);
    }
}
