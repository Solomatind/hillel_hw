package com.hillel.web;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.hillel.filmlibrary.service.FilmLibrary;
import com.hillel.filmlibrary.service.impl.DBFilmLibrary;

@WebServlet("/deleteFilm")
public class DeleteFilm extends HttpServlet {
    private static final long serialVersionUID = 1L;

    private FilmLibrary lib;

    public DeleteFilm() {
        lib = new DBFilmLibrary();
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        request.getRequestDispatcher("/jsp/deleteFilm.jsp").forward(request, response);
    }

    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        int countOfDeletingFilms = lib.deleteFilmsOlderGivenYears(Integer.parseInt(request.getParameter("years")));
        request.setAttribute("count", countOfDeletingFilms);
        request.getRequestDispatcher("/jsp/deleteFilm.jsp").forward(request, response);
    }

}
