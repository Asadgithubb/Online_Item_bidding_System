package com.example.onlineitembid.Model;

public class userModel {
    String id;
    String username;
    String userEmail;
    String userPassword;
    String phoneNumber;

    public userModel(String username, String email, String password, String phoneNumber) {

    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getUserEmail() {
        return userEmail;
    }

    public void setUserEmail(String userEmail) {
        this.userEmail = userEmail;
    }
    public String getUserPassword() {
        return userPassword;
    }

    public void setUserPassword(String userPassword) {
        this.userPassword = userPassword;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    public userModel() {
    }

    public userModel(String id, String username,String userEmail, String phoneNumber,String userPassword) {
        this.id = id;
        this.username = username;
        this.userEmail = userEmail;
        this.userPassword = userPassword;
        this.phoneNumber = phoneNumber;
    }
}
