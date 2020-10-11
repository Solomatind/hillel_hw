package com.hillel.filmlibrary.runner;

import java.sql.SQLException;

import com.hillel.filmlibrary.engine.FilmLibraryWorker;

public class FilmLibraryRunner {

    public static void main(String[] args) {
        FilmLibraryWorker worker = null;
        try {
            worker = new FilmLibraryWorker();
            System.out.println(worker.findFilmsForCurrentAndLastYear());
            System.out.println();
            System.out.println(worker.findActorsForFilm("Tenet"));
            System.out.println();
            System.out.println(worker.findActorsForNFilm(2));
            System.out.println();
            System.out.println(worker.findActorsAsDirector());
            System.out.println();
            //System.out.println(worker.deleteFilmsOlderGivenYears(20));
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            try {
                worker.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
    }

}
