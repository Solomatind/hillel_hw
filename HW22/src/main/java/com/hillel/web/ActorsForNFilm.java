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

@WebServlet("/actorsForNFilm")
public class ActorsForNFilm extends HttpServlet {
    private static final long serialVersionUID = 1L;

    private FilmLibrary lib;

    public ActorsForNFilm() {
        lib = new DBFilmLibrary();
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        request.getRequestDispatcher("/jsp/actorsForNFilm.jsp").forward(request, response);
    }

    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        List<Actor> actors = lib.getActorsForNFilm((Integer.parseInt(request.getParameter("film"))));
        request.setAttribute("actors", actors);
        request.getRequestDispatcher("/jsp/actorsForNFilm.jsp").forward(request, response);
    }

}
