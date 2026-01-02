package com.mycompany.app.hub;

import java.util.ArrayList;

/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

/**
 *
 * @author Tan
 */
public class LoginSecurity {

    // User class
    public static class User {
        private String firstName, lastName, email, password;
        private int accessLevel;
        
        public String getFirstName()
        {
            return firstName;
        }
        
        public String getlastName()
        {
            return lastName;
        }

        public User(String firstName, String lastName, String email, String password, int accessLevel) {
            this.firstName = firstName;
            this.lastName = lastName;
            this.email = email;
            this.password = password;
            this.accessLevel = accessLevel;
        }
        
        // Getters
        public String getEmail() { return email; }
        public String getPassword() { return password; }
        public int getAccess() { return accessLevel; }
    }
    
    public static User currentUser;
    
    public static ArrayList<quizPanel.ScoreEntry> leaderboards = new ArrayList<>();

    private static ArrayList<User> users = new ArrayList<>();

    // Tracks login attempts
    public static int attempts = 3;

    // Constructor
    public LoginSecurity() {
        users.add(new User("Admin", "User", "AdminEmail", "AdminPassword", 0));
        users.add(new User("Standard", "User", "UserEmail", "UserPassword", 1));
        users.add(new User("Bob", "Smith", "bob@email.com", "Pass456", 1));
        users.add(new User("Jane", "Hopper", "admin@email.com", "Pass123", 2));
        users.add(new User("Will", "the Wise", "char@email.com", "Pass789", 1));
    }

    public void signup(String fName, String lName, String email, String pass, int level) {
        users.add(new User(fName, lName, email, pass, level));
    }
    
    public static void guest() {
        currentUser = new User("Guest", "", "", "", 2);
    }
    
    public User login(String email, String password) {
        if (attempts <= 0) {
            System.out.println("No login attempts left.");
            return null;
        }

        for (User u : users) {
            if (u.getEmail().equals(email) && u.getPassword().equals(password)) {
                System.out.println("Login successful!");
                return u;
            }
        }

        attempts--;
        System.out.println("Login failed. Attempts left: " + attempts);
        return null;
    }

    
}

