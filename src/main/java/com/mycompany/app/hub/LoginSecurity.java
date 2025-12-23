package com.mycompany.app.hub;

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
        private String email;
        private String password;
        private int accessLevel;

        public User(String email, String password, int accessLevel) {
            this.email = email;
            this.password = password;
            this.accessLevel = accessLevel;
        }

        // Getters
        public String getEmail() { return email; }
        public String getPassword() { return password; }
        public int getAccessLevel() { return accessLevel; }

        // Optional: setters if needed
        public void setPassword(String password) { this.password = password; }
    }

    // Array of users
    private User[] users;

    // Tracks login attempts
    public static int attempts = 3;

    // Constructor
    public LoginSecurity() {
        // Initialize users array
        users = new User[] {
            new User("AdminEmail", "AdminPassword", 0), // accessLevel 0 = admin
            new User("UserEmail", "UserPassword", 1), // accessLevel 1 = user
            new User("GuestEmail", "GuestPassword", 2) // accessLevel 2 = guest
        };
    }

    // Check login method
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

    // Getter for users array
    public User[] getUsers() {
        return users;
    }
}

