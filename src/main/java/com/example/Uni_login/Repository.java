package com.example.Uni_login;

import com.example.Uni_login.models.Users;

public class Repository {
    private static Users instance = new Users(); // Eagerly Loading of singleton instance

    private Users Users(){
        return new Users();
    }

    public static Users getInstance() {
        return instance;
    }
    public Users getUsers(){
        return instance;
    }
}
