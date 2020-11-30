package com.hillel.web.authorization;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.hillel.filmlibrary.entities.User;
import com.hillel.filmlibrary.service.FilmLibrary;
import com.hillel.filmlibrary.service.impl.DBFilmLibrary;

@WebServlet("/authorization")
public class Authorization extends HttpServlet {
    private static final long serialVersionUID = 1L;

    private FilmLibrary lib;

    public Authorization() {
        lib = new DBFilmLibrary();
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        request.getRequestDispatcher("/jsp/authorization.jsp").forward(request, response);
    }

    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        List<User> users = lib.getUsers();
        User user = new User(request.getParameter("userName"), request.getParameter("password"));
        if (users.contains(user)) {
            request.getSession().setAttribute("user", user);
            response.sendRedirect("index.jsp");
        } else {
            request.setAttribute("incorrect", "Incorrect password or username");
            request.getRequestDispatcher("/jsp/authorization.jsp").forward(request, response);
        }
    }

}
