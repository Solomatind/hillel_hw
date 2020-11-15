package com.hillel.filmlibrary.dbengine;

public class FilmLibraryQuery {

    public final static String CURRENT_PREV_YEAR_FILMS = "SELECT films.*, directors.*, GROUP_CONCAT(actors.idactors SEPARATOR ', ') AS actor_ids, GROUP_CONCAT(actors.actor_name SEPARATOR ', ') AS actor_names, GROUP_CONCAT(actors.actor_birthday SEPARATOR ', ') AS actor_birthdays FROM films JOIN directors ON films.director_id = directors.iddirectors JOIN films_actors ON films.idfilms = films_actors.idfilms JOIN actors ON films_actors.idactors = actors.idactors WHERE films.release_date = 2019 OR films.release_date = 2020 GROUP BY films.idfilms;";
    public final static String ACTORS_AS_DIRECTORS = "SELECT actors.* FROM films JOIN directors ON director_id = iddirectors JOIN films_actors ON films.idfilms = films_actors.idfilms JOIN actors ON films_actors.idactors = actors.idactors WHERE actor_name = director_name AND actor_birthday = director_birthday;";
    public final static String ACTORS_FOR_FILM = "SELECT actors.* FROM actors JOIN films_actors ON actors.idactors = films_actors.idactors JOIN films ON films_actors.idfilms = films.idfilms WHERE films.film_name = ?;";
    public final static String ACTORS_FOR_N_FILM = "SELECT actors.*, COUNT(films_actors.idactors) count FROM actors JOIN films_actors ON actors.idactors = films_actors.idactors GROUP BY films_actors.idactors HAVING count >= ?;";
    public final static String DELETE_FILMS_BY_MORE_THEN_GIVEN_YEARS = "DELETE FROM films WHERE YEAR(CURRENT_DATE()) - release_date > ?;";
    public final static String USERS = "SELECT * FROM films_library.user";

}
