package com.epam.totalizator.web;


import com.epam.totalizator.core.DBManager;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.rmi.UnknownHostException;
import java.util.Enumeration;

/**
 * Created with IntelliJ IDEA.
 * User: Zdybai
 * Date: 10.12.13
 * Time: 0:14
 * To change this template use File | Settings | File Templates.
 */
@WebServlet("/bets")
public class BetsListServlet extends HttpServlet {
    @Override
    public void doGet(HttpServletRequest req, HttpServletResponse resp) throws UnknownHostException, ServletException, IOException {
        DBManager manager = new DBManager();
        Enumeration<String> params = req.getParameterNames();
        String paramEventId = req.getParameter("eventId");
        int eventId = Integer.parseInt(paramEventId);
        req.setAttribute("bets", manager.getBets(eventId));
        req.getRequestDispatcher("/WEB-INF/views/betsList.jsp").forward(req, resp);
    }
}
