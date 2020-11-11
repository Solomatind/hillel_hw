package com.hillel.filmlibrary.dbengine;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.List;

import javax.naming.NamingException;

import com.hillel.filmlibrary.connection.ConnectorDB;
import com.hillel.filmlibrary.entities.Actor;
import com.hillel.filmlibrary.entities.Director;
import com.hillel.filmlibrary.entities.Film;
import com.hillel.filmlibrary.function.SQLFunction;

public class FilmLibraryDBWorker {

    public List<Film> findFilmsForCurrentAndLastYear() {
        return getResult(st -> {
            List<Film> filmList = new ArrayList<>();
            try (ResultSet result = st.executeQuery()) {
                while (result.next()) {
                    List<Actor> actorList = new ArrayList<>();
                    String[] actorIds = result.getString("actor_ids").split(", ");
                    String[] actorNames = result.getString("actor_names").split(", ");
                    String[] actorBirthdays = result.getString("actor_birthdays").split(", ");
                    for (int i = 0; i < actorNames.length; i++) {
                        SimpleDateFormat format = new SimpleDateFormat();
                        format.applyPattern("yyyy-MM-dd");
                        actorList.add(new Actor(Integer.valueOf(actorIds[i]), actorNames[i],
                                format.parse(actorBirthdays[i])));
                    }
                    filmList.add(new Film(result.getInt("idfilms"), result.getString("film_name"),
                            new Director(result.getInt("iddirectors"), result.getString("director_name"),
                                    result.getDate("director_birthday")),
                            result.getInt("release_date"), result.getString("country"), actorList));
                }
            } catch (SQLException e) {
                e.printStackTrace();
            } catch (ParseException e) {
                e.printStackTrace();
            }

            return filmList;
        }, FilmLibraryQuery.CURRENT_PREV_YEAR_FILMS);
    }

    public List<Actor> findActorsForFilm(String film) {
        return getResult(st -> {
            st.setString(1, film);
            ResultSet result = st.executeQuery();
            return makeActorListBySet(result);
        }, FilmLibraryQuery.ACTORS_FOR_FILM);
    }

    public List<Actor> findActorsForNFilm(int filmsCount) {
        return getResult(st -> {
            st.setInt(1, filmsCount);
            ResultSet result = st.executeQuery();
            return makeActorListBySet(result);
        }, FilmLibraryQuery.ACTORS_FOR_N_FILM);
    }

    public List<Actor> findActorsAsDirector() {
        return getResult(st -> {
            ResultSet result = st.executeQuery();
            return makeActorListBySet(result);
        }, FilmLibraryQuery.ACTORS_AS_DIRECTORS);
    }

    public int removeFilmsOlderGivenYears(int givenYears) {
        return getResult(st -> {
            st.setInt(1, givenYears);
            return st.executeUpdate();
        }, FilmLibraryQuery.DELETE_FILMS_BY_MORE_THEN_GIVEN_YEARS);
    }

    private <R> R getResult(SQLFunction<PreparedStatement, R> function, String statement) {
        Connection con = null;
        PreparedStatement st = null;
        try {
            con = ConnectorDB.getConnection();
            st = con.prepareStatement(statement);
            return function.apply(st);
        } catch (SQLException | NamingException e) {
            e.printStackTrace();
        } finally {
            closeConnection(con);
            closeStatement(st);
        }
        return null;
    }

    private List<Actor> makeActorListBySet(ResultSet result) throws SQLException {
        List<Actor> actorList = new ArrayList<>();
        while (result.next()) {
            actorList.add(new Actor(result.getInt("idactors"), result.getString("actor_name"),
                    result.getDate("actor_birthday")));
        }
        return actorList;
    }

    public void closeStatement(PreparedStatement st) {
        try {
            if (st != null) {
                st.close();
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public void closeConnection(Connection con) {
        try {
            if (con != null) {
                con.close();
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

}
