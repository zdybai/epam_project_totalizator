package com.epam.totalizator.web;

import com.epam.totalizator.core.DBManager;
import com.epam.totalizator.core.domain.Bet;
import com.epam.totalizator.core.domain.User;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
/**
 * Created with IntelliJ IDEA.
 * User: Zdybai
 * Date: 24.12.13
 * Time: 4:49
 * To change this template use File | Settings | File Templates.
 */
@WebServlet(name="AddBetServlet", urlPatterns={"/addbet"})
public class AddBetServlet extends HttpServlet {


    public void doGet(HttpServletRequest req, HttpServletResponse resp)
            throws ServletException, java.io.IOException {

        DBManager manager = new DBManager();
        String paramAmount = req.getParameter("amount");
        int amount = Integer.parseInt(paramAmount);
        HttpSession session = req.getSession();
        User user = (User) session.getAttribute("currentSessionUser");
        int eventId = (Integer) session.getAttribute("currentEventId");
                Bet bet = manager.createBet(user.getId(), eventId, amount, true);
        if(user == null) {
            req.getRequestDispatcher("/WEB-INF/views/ErrorAddBet.jsp").forward(req, resp);
        } else {
            req.getRequestDispatcher("/events").forward(req, resp);
        }
    }
}
