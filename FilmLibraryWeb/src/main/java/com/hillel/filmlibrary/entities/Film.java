package com.hillel.filmlibrary.entities;

import java.util.List;
import java.util.stream.Collectors;

public class Film extends Entity {

    private String name;
    private Director director;
    private int releaseYear;
    private String country;
    private List<Actor> actors;

    public Film(int id, String name, Director director, int releaseYear, String country, List<Actor> actors) {
        super(id);
        this.name = name;
        this.director = director;
        this.releaseYear = releaseYear;
        this.country = country;
        this.actors = actors;
    }

    public String getName() {
        return name;
    }

    public Director getDirector() {
        return director;
    }

    public int getReleaseYear() {
        return releaseYear;
    }

    public String getCountry() {
        return country;
    }

    public List<Actor> getActors() {
        return actors;
    }

    public String toString() {
        return name + " | " + director.getName() + " | " + releaseYear + " | " + country + " | "
                + actors.stream().map((actor) -> actor.getName()).collect(Collectors.toList()) + "\n";
    }

}
