package com.hillel.filmlibrary.entities;

import java.util.Objects;

public class User extends Entity {

    private String userName;
    private String password;

    public User(int userId, String userName, String password) {
        super(userId);
        this.userName = userName;
        this.password = password;
    }

    public User(String userName, String password) {
        super(0);
        this.userName = userName;
        this.password = password;
    }

    public String getUserName() {
        return userName;
    }

    public String getPassword() {
        return password;
    }

    public String toString() {
        return userName;
    }

    public boolean equals(Object o) {
        if (!(o instanceof User)) {
            return false;
        }
        User other = (User) o;
        return (Objects.equals(other.userName, this.userName) && Objects.equals(other.password, this.password));
    }

}
