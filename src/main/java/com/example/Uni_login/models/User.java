package com.example.Uni_login.models;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import java.util.Random;

public class User implements Serializable { //user with different abilities
    private long id;
    private String name;
    private String username;
    private String password;
    private String workName;
    private String description;
    private String email;
    private String town;
    private String phone;
    private String address;
    private List<Ability> profAbilities = new ArrayList<>();
    private List<Ability> persAbilities = new ArrayList<>();

    public User() {
        Random rand = new Random();
        id = rand.nextLong();
    }

    public User(String name, String username, String password) {
        Random rand = new Random();
        id = rand.nextLong();
        this.name = name;
        this.username = username;
        this.password = password;

        this.addProfAbility(new Ability("Java",50));
        this.addPersAbility(new Ability("Communicaiton",62));
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
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

    public void setWorkName(String workName) {
        this.workName = workName;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getTown() {
        return town;
    }

    public void setTown(String town) {
        this.town = town;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public List<Ability> getProfAbilities() {
        return profAbilities;
    }

    public void setProfAbilities(List<Ability> profAbilities) {
        this.profAbilities = profAbilities;
    }

    public List<Ability> getPersAbilities() {
        return persAbilities;
    }

    public void setPersAbilities(List<Ability> persAbilities) {
        this.persAbilities = persAbilities;
    }

    public void addProfAbility(Ability x)
    {
        profAbilities.add(x);
    }

    public void addPersAbility(Ability x)
    {
        persAbilities.add(x);
    }
    public String getWorkName() {
        return workName;
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
                ", abilities=" + profAbilities +
                '}';
    }
}
