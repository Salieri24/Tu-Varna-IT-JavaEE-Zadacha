package com.example.Uni_login.models;

import java.io.Serializable;
import java.util.List;
import java.util.Objects;

public class User implements Serializable { //user with different abilities
    private String name;
    private String username;
    private String password;
    private List<Ability> abilities;

    public User(String name, String username, String password) {
        this.name = name;
        this.username = username;
        this.password = password;
    }


    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public Ability getAbility(String name){
        for(Ability x : abilities) {
            if(x.getName().equals(name))
            return x;
        }
        return null;
    }
    public void addAbility(Ability x)
    {
        abilities.add(x);
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        User user = (User) o;
        return username.equals(user.username) && password.equals(user.password);
    }
    @Override
    public int hashCode() {
        return Objects.hash(username, password);
    }

    @Override
    public String toString() {
        return "User{" +
                "name='" + name + '\'' +
                ", username='" + username + '\'' +
                ", password='" + password + '\'' +
                ", abilities=" + abilities +
                '}';
    }
}
