package com.example.Uni_login.models;

import java.util.HashSet;

public class Users {    //collection of users

    private HashSet<User> Users = new HashSet<>();

    public HashSet<User> getUserList() {
        return Users;
    }
    public void addUser(User user) {
        Users.add(user);
    }
    public User checkForUser(User user){
        for(User x : Users)
        {
            if (x.equals(user)) {
                return x;
            }
        }
        return null;
    }
    //Check for an already existing username
    public boolean checkForUsername(String username){
        if(Users.isEmpty()) return false;
        for(User x : Users)
        {
            if (x.getName().equals(username)){
                return true;
            }
        }
        return false;
    }

    public User getUserById(long id) {
        if(Users.isEmpty()) return null;
        for(User x : Users)
        {
            if (x.getId()==id){
                return x;
            }
        }
        return null;
    }
}

