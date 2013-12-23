package com.epam.totalizator.web;

import com.epam.totalizator.core.DBManager;
import com.epam.totalizator.core.domain.User;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

@WebServlet(name="LogoutServlet", urlPatterns={"/logout"})
public class LogoutServlet extends HttpServlet {


    public void doGet(HttpServletRequest req, HttpServletResponse resp)
            throws ServletException, java.io.IOException {

        HttpSession session = req.getSession(true);
        session.removeAttribute("currentSessionUser");
        req.getRequestDispatcher("./").forward(req, resp);
    }
}