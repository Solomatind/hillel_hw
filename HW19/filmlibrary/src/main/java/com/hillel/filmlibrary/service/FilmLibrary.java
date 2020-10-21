package com.hillel.filmlibrary.service;

import java.util.List;

import com.hillel.filmlibrary.entities.Actor;
import com.hillel.filmlibrary.entities.Film;

public interface FilmLibrary {

    List<Film> getFilmsForCurrentAndLastYear();
    List<Actor> getActorsForFilm(String film);
    List<Actor> getActorsForNFilm(int filmsCount);
    List<Actor> getActorsAsDirector();
    int deleteFilmsOlderGivenYears(int givenYears);
    
}
