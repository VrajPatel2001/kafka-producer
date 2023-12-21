package com.producer.model;


public class User {

    int userId;
    String name;
    String emailId;
    Long phone;

    public User(int userId, String name, String emailId, Long phone) {
        this.userId = userId;
        this.name = name;
        this.emailId = emailId;
        this.phone = phone;
    }

    public User() {
    }

    public int getUserId() {
        return userId;
    }

    public void setUserId(int userId) {
        this.userId = userId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getEmailId() {
        return emailId;
    }

    public void setEmailId(String emailId) {
        this.emailId = emailId;
    }

    public Long getPhone() {
        return phone;
    }

    public void setPhone(Long phone) {
        this.phone = phone;
    }
}

