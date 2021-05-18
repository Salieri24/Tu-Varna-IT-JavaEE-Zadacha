package com.example.Uni_login;

public final class Validation {
    public static boolean checkPassword(String password) {
        return password.length() <= 8;
    }

    public static boolean checkUsername(String username) {
        return username.length() <= 8;
    }

    public static boolean checkName(String name) {
        return name.length()>2;
    }

    public static void checkUser(String name,String username,String password, String password2) throws Exception {
        if (!checkName(name)) {
            throw new Exception("Name must be valid");
        }
        if (checkUsername(username)) {
            throw new Exception("Username must be valid");
        }

        if (checkPassword(password)) {
            throw new Exception("Password must be valid");
        }
        if (!password.equals(password2)) {
            throw new Exception("Passwords do not match!");
        }

    }
}
