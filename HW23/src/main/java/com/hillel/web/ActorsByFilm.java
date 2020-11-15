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

@WebServlet("/actorsByFilm")
public class ActorsByFilm extends HttpServlet {
    private static final long serialVersionUID = 1L;

    private FilmLibrary lib;

    public ActorsByFilm() {
        lib = new DBFilmLibrary();
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        request.getRequestDispatcher("/jsp/actorsByFilm.jsp").forward(request, response);
    }

    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        List<Actor> actors = lib.getActorsForFilm(request.getParameter("film"));
        request.setAttribute("actors", actors);
        request.getRequestDispatcher("/jsp/actorsByFilm.jsp").forward(request, response);
    }

}
