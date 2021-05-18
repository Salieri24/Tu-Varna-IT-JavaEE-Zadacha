package com.example.Uni_login;

import com.example.Uni_login.models.Users;

public class Repository {
    private static Users instance; // Eagerly Loading of singleton instance

    private Users Users(){
        return new Users();
    }

    public static Users getInstance() {
        if(instance == null) instance = new Users();
        return instance;
    }
}
