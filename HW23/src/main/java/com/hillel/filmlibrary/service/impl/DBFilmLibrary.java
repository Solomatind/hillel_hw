package com.hillel.filmlibrary.service.impl;

import java.util.List;

import com.hillel.filmlibrary.dbengine.FilmLibraryDBWorker;
import com.hillel.filmlibrary.entities.Actor;
import com.hillel.filmlibrary.entities.Film;
import com.hillel.filmlibrary.entities.User;
import com.hillel.filmlibrary.service.FilmLibrary;

public class DBFilmLibrary implements FilmLibrary {
    
    private FilmLibraryDBWorker worker;
    
    public DBFilmLibrary() {
        worker = new FilmLibraryDBWorker();
    }

    @Override
    public List<Film> getFilmsForCurrentAndLastYear() {
        return worker.findFilmsForCurrentAndLastYear();
    }

    @Override
    public List<Actor> getActorsForFilm(String film) {
        return worker.findActorsForFilm(film);
    }

    @Override
    public List<Actor> getActorsForNFilm(int filmsCount) {
        return worker.findActorsForNFilm(filmsCount);
    }
    
    @Override
    public List<Actor> getActorsAsDirector() {
        return worker.findActorsAsDirector();
    }

    @Override
    public int deleteFilmsOlderGivenYears(int givenYears) {
        return worker.removeFilmsOlderGivenYears(givenYears);
    }

    @Override
    public List<User> getUsers() {
        return worker.getUsers();
    }

}
