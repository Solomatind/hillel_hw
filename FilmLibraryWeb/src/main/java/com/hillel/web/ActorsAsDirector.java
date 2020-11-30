package com.hillel.web;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.hillel.filmlibrary.entities.Actor;
import com.hillel.filmlibrary.service.FilmLibrary;
import com.hillel.filmlibrary.service.impl.DBFilmLibrary;

@WebServlet("/actorsAsDirector")
public class ActorsAsDirector extends HttpServlet {
    private static final long serialVersionUID = 1L;

    private FilmLibrary lib;

    public ActorsAsDirector() {
        lib = new DBFilmLibrary();
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        List<Actor> actors = lib.getActorsAsDirector();
        request.setAttribute("actors", actors);
        request.getRequestDispatcher("/index.jsp").forward(request, response);
    }

}
