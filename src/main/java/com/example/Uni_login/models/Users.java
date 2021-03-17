package com.example.Uni_login.models;

import java.util.ArrayList;
import java.util.List;

public class Users {    //collection of users

    private List<User> userList= new ArrayList<>();

    public List<User> getUserList() {
        return userList;
    }
    public void addUser(User user) {
        userList.add(user);
    }
}
