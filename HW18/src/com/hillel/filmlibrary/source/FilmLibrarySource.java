package com.hillel.filmlibrary.source;

import java.sql.ResultSet;
import java.sql.SQLException;

public interface FilmLibrarySource {

    ResultSet getResultSet(String sqlSquery) throws SQLException;

    ResultSet getResultSet(String sqlQuery, String film) throws SQLException;

    ResultSet getResultSet(String sqlQuery, int filmsCount) throws SQLException;

    int removeFilmsOlderGivenYears(int givenYears) throws SQLException;

    void close() throws SQLException;
}
