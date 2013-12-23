package com.epam.totalizator.web;

import com.epam.totalizator.core.DBManager;
import com.epam.totalizator.core.domain.User;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet(name="RegisterServlet", urlPatterns={"/register"})
public class RegisterServlet extends HttpServlet {


    public void doGet(HttpServletRequest req, HttpServletResponse resp)
            throws ServletException, java.io.IOException {

        DBManager manager = new DBManager();
        String login = req.getParameter("un");
        String pass = req.getParameter("pw");
        User user = null;
        if(!login.isEmpty() && !pass.isEmpty())
            user = manager.register(login, pass);
        if(user == null) {
            req.getRequestDispatcher("/WEB-INF/views/ErrorLogin.jsp").forward(req, resp);
        } else {
            req.getRequestDispatcher("./").forward(req, resp);
        }
    }
}