package com.hillel.filmlibrary.entity;

import java.util.Date;

public class Director {
    
    private String name;
    private Date birthday;
    
    public Director(String name, Date birthday) {
        this.name = name;
        this.birthday = birthday;
    }
    
    public Date getBirthday() {
        return birthday;
    }
    
    public String getName() {
        return name;
    }
    
    public String toString() {
        return name + " " + birthday;
    }

}
