package com.hillel.filmlibrary.dbengine;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import com.hillel.filmlibrary.connection.ConnectorDB;
import com.hillel.filmlibrary.source.FilmLibrarySource;

public class FilmLibraryDBWorker implements FilmLibrarySource {

    private Connection connection;

    public FilmLibraryDBWorker() throws SQLException {
        connection = ConnectorDB.getConnection();
    }

    public ResultSet getResultSet(String sqlQuery) throws SQLException {
        return getStatement(sqlQuery).executeQuery();
    }

    public ResultSet getResultSet(String sqlQuery, String film) throws SQLException {
        PreparedStatement preparedSt = getStatement(sqlQuery);
        preparedSt.setString(1, film);
        return preparedSt.executeQuery();
    }

    public ResultSet getResultSet(String sqlQuery, int filmsCount) throws SQLException {
        PreparedStatement preparedSt = getStatement(sqlQuery);
        preparedSt.setInt(1, filmsCount);
        return preparedSt.executeQuery();
    }

    public int removeFilmsOlderGivenYears(int givenYears) throws SQLException {
        PreparedStatement prepareSt = getStatement(FilmLibraryQuery.DELETE_FILMS_BY_MORE_THEN_GIVEN_YEARS);
        prepareSt.setInt(1, givenYears);
        return prepareSt.executeUpdate();
    }

    private PreparedStatement getStatement(String sqlQuery) throws SQLException {
        PreparedStatement st = connection.prepareStatement(sqlQuery);
        return st;
    }

    public void close() throws SQLException {
        connection.close();
    }

}
