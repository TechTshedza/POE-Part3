/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.main;
import javax.swing.JOptionPane;

/**
 *
 * @author Muthivhi_Tshedza
 */
class Login {
    private String username;
    private String password;
    private String firstName;
    private String lastName;

    // Check if the username is valid
    public boolean checkUserName(String username) {
        return username.contains("_") && username.length() <= 5;
    }

    // Check password complexity
    public boolean checkPasswordComplexity(String password) {
         if (password.length() >= 8 && password.matches(".*[A-Z].*") && password.matches(".*\\d.*") && password.matches(".*[^a-zA-Z0-9].*")) {
            System.out.println("Password successfully captured");
            return true;
        } else {
            System.out.println("Password is not correctly formatted, please ensure that the password contains at least 8 characters, a capital letter, a number and a special character.");
            return false;}
    }

    // Register a new user
    public String registerUser(String username, String password, String firstName, String lastName) {
        if (!checkUserName(username)) {
            return "Username is not correctly formatted, please ensure that username or password is correct.";
        }
        if (!checkPasswordComplexity(password)) {
            return "Password is not correctly formatted.";
        }
        this.username = username;
        this.password = password;
        this.firstName = firstName;
        this.lastName = lastName;
        return "Username and Password successfully captured.";
    }

    // Login the user
    public String loginUser(String username, String password) {
        if (this.username != null && this.username.equals(username) && this.password.equals(password)) {
            return "Welcome " + firstName + ", " + lastName + ", it is great to see you again.";
        }
        return "Username or password incorrect, please try again.";
    }
}