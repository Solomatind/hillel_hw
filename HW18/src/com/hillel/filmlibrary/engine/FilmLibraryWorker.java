package com.hillel.filmlibrary.engine;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.List;

import com.hillel.filmlibrary.dbengine.FilmLibraryDBWorker;
import com.hillel.filmlibrary.dbengine.FilmLibraryQuery;
import com.hillel.filmlibrary.entity.Actor;
import com.hillel.filmlibrary.entity.Director;
import com.hillel.filmlibrary.entity.Film;
import com.hillel.filmlibrary.source.FilmLibrarySource;

public class FilmLibraryWorker {

    private FilmLibrarySource worker;

    public FilmLibraryWorker() throws SQLException {
        worker = new FilmLibraryDBWorker();
    }

    public List<Film> findFilmsForCurrentAndLastYear() {
        List<Film> filmList = new ArrayList<>();
        try (ResultSet result = worker.getResultSet(FilmLibraryQuery.CURRENT_PREV_YEAR_FILMS);) {
            while (result.next()) {
                List<Actor> actorList = new ArrayList<>();
                String[] actorNames = result.getString("actor_names").split(", ");
                String[] actorBirthdays = result.getString("actor_birthdays").split(", ");
                for (int i = 0; i < actorNames.length; i++) {
                    SimpleDateFormat format = new SimpleDateFormat();
                    format.applyPattern("yyyy-MM-dd");
                    actorList.add(new Actor(actorNames[i], format.parse(actorBirthdays[i])));
                }
                filmList.add(new Film(result.getString("film_name"),
                        new Director(result.getString("director_name"), result.getDate("director_birthday")),
                        result.getInt("release_date"), result.getString("country"), actorList));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        } catch (ParseException e) {
            e.printStackTrace();
        }
        return filmList;
    }

    public List<Actor> findActorsForFilm(String film) {
        List<Actor> actorList = new ArrayList<>();
        try (ResultSet result = worker.getResultSet(FilmLibraryQuery.ACTORS_FOR_FILM, film);) {
            actorList = makeActorListBySet(result);
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return actorList;
    }

    public List<Actor> findActorsForNFilm(int filmsCount) {
        List<Actor> actorList = new ArrayList<>();
        try (ResultSet result = worker.getResultSet(FilmLibraryQuery.ACTORS_FOR_N_FILM, filmsCount);) {
            actorList = makeActorListBySet(result);
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return actorList;
    }

    public List<Actor> findActorsAsDirector() {
        List<Actor> actorList = new ArrayList<>();
        try (ResultSet result = worker.getResultSet(FilmLibraryQuery.ACTORS_AS_DIRECTORS);) {
            actorList = makeActorListBySet(result);
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return actorList;
    }

    public int deleteFilmsOlderGivenYears(int givenYears) {
        try {
            return worker.removeFilmsOlderGivenYears(givenYears);
        } catch (SQLException e) {
            e.printStackTrace();
            return 0;
        }
    }

    public void close() throws SQLException {
        worker.close();
    }

    private List<Actor> makeActorListBySet(ResultSet result) throws SQLException {
        List<Actor> actorList = new ArrayList<>();
        while (result.next()) {
            actorList.add(new Actor(result.getString("actor_name"), result.getDate("actor_birthday")));
        }
        return actorList;
    }

}
