package com.epam.totalizator.web;


import com.epam.totalizator.core.DBManager;
import com.epam.totalizator.core.domain.User;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;


/** * Created with IntelliJ IDEA.
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
        String paramUserId = req.getParameter("userId");
        HttpSession session = req.getSession();
        User user = (User) session.getAttribute("currentSessionUser");
        req.setAttribute("currentUser", user);
        req.setAttribute("events", (paramUserId == null) ? manager.getEvents() :
                manager.getEvents(Integer.parseInt(paramUserId)));
        if(user.getId() != 1)
            req.getRequestDispatcher("/WEB-INF/views/eventsList.jsp").forward(req, resp);
        else
            req.getRequestDispatcher("/WEB-INF/views/eventsListAdmin.jsp").forward(req, resp);
    }
}
