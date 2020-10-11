package com.hillel.filmlibrary.entity;

import java.util.Date;

public class Actor {

    private String name;
    private Date birthday;

    public Actor(String name, Date birthday) {
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
