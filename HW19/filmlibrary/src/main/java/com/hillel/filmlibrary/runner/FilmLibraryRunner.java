package com.hillel.filmlibrary.runner;

import com.hillel.filmlibrary.service.FilmLibrary;
import com.hillel.filmlibrary.service.impl.DBFilmLibrary;

public class FilmLibraryRunner {

    public static void main(String[] args) {
        FilmLibrary worker = new DBFilmLibrary();
            System.out.println(worker.getFilmsForCurrentAndLastYear());
            System.out.println();
            System.out.println(worker.getActorsForFilm("Tenet"));
            System.out.println();
            System.out.println(worker.getActorsForNFilm(2));
            System.out.println();
            System.out.println(worker.getActorsAsDirector());
            System.out.println();
            // System.out.println(worker.deleteFilmsOlderGivenYears(20));
    }

}
