package com.devzone.model;

public class User {
    private String uID = null;
    private String uName = null;
    private String uPassword = null;
    private String uAStatus = null;

    public User() {
    }
    public User(String uID, String uName,String uPassword, String uAStatus) {
        this.uID = uID;
        this.uName = uName;
        this.uPassword = uPassword;
        this.uAStatus = uAStatus;
    }

    public String getuID() {
        return uID;
    }

    public void setuID(String uID) {
        this.uID = uID;
    }

    public String getuName() {
        return uName;
    }

    public void setuName(String uName) {
        this.uName = uName;
    }

    public String getuPassword() {
        return uPassword;
    }

    public void setuPassword(String uPassword) {
        this.uPassword = uPassword;
    }

    public String getuAStatus() {
        return uAStatus;
    }

    public void setuAStatus(String uAStatus) {
        this.uAStatus = uAStatus;
    }
    
    

}
