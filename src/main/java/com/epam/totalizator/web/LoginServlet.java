package com.epam.totalizator.web;

import com.epam.totalizator.core.DBManager;
import com.epam.totalizator.core.domain.User;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

@WebServlet(name="LoginServlet", urlPatterns={"/login"})
public class LoginServlet extends HttpServlet {


    public void doGet(HttpServletRequest req, HttpServletResponse resp)
            throws ServletException, java.io.IOException {

        DBManager manager = new DBManager();
        String login = req.getParameter("un");
        String pass = req.getParameter("pw");
        User user = manager.login(login, pass);
        if(user == null) {
            req.getRequestDispatcher("/WEB-INF/views/ErrorLogin.jsp").forward(req, resp);
        } else {
            HttpSession session = req.getSession(true);
            session.setAttribute("currentSessionUser",user);
            req.getRequestDispatcher("/events").forward(req, resp);
        }
    }
}