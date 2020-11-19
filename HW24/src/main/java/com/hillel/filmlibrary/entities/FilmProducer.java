package com.hillel.filmlibrary.entities;

import java.util.Date;

public class FilmProducer extends Entity {
    
    private String name;
    private Date birthday;
    
    public FilmProducer(int id, String name, Date birthday) {
        super(id);
        this.name = name;
        this.birthday = birthday;
    }

    public Date getBirthday() {
        return birthday;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setBirthday(Date birthday) {
        this.birthday = birthday;
    }

    public String toString() {
        return name + " " + birthday;
    }

}
