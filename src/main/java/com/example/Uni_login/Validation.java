package com.example.Uni_login;

public final class Validation {
    public static boolean checkPassword(String password) {
        return password.length() > 8;
    }

    public static boolean checkUsername(String username) {
        return username.length()>8;
    }
    public static boolean checkName(String name) {
        return name.length()>0;
    }
}
