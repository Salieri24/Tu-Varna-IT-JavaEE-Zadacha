package com.example.Uni_login.models;

import com.example.Uni_login.Repository;

import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Marshaller;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElementWrapper;
import javax.xml.bind.annotation.XmlRootElement;
import java.io.File;
import java.util.HashSet;

@XmlRootElement
@XmlAccessorType(XmlAccessType.FIELD)
public class Users {    //collection of users
    @XmlElementWrapper
    private HashSet<User> users = new HashSet<>();

    public HashSet<User> getUserList() {
        return users;
    }
    public void setUsers(HashSet<User> users) {
        this.users = users;
    }

    public void addUser(User user) {
        users.add(user);
        Repository.writeToXMLFile();
    }
    public User checkForUser(User user){
        for(User x : users)
        {
            if (x.equals(user)) {
                return x;
            }
        }
        return null;
    }
    //Check for an already existing username
    public boolean checkForUsername(String username){
        if(users.isEmpty()) return false;
        for(User x : users)
        {
            if (x.getUsername().equals(username)){
                return true;
            }
        }
        return false;
    }

    public User getUserById(long id) {
        if(users.isEmpty()) return null;
        for(User x : users)
        {
            if (x.getId()==id){
                return x;
            }
        }
        return null;
    }

    public void saveUser(User user) {
        if(users.isEmpty()) return;
        for(User x : users)
        {
            if (x.getId()==user.getId()){
                users.remove(x);
                addUser(user);
                return;
            }
        }
        addUser(user);
    }
}

