package com.example.Uni_login;

import com.example.Uni_login.models.Users;
import com.example.Uni_login.xml.JaxbFileSave;

public class Repository {


    private static Repository instance; // Eagerly Loading of singleton instance
    private Users users;

    private Repository() {
        this.users = JaxbFileSave.readFromXMLFile();
    }

    public static Repository getInstance() {
        if(instance == null) {
            instance = new Repository();
        }
        return instance;
    }

    public Users getUsers(){
        return users;
    }

    public void setUsers(Users users) {
        this.users = users;
    }
}
