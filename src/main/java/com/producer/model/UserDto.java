package com.producer.model;


public class UserDto {

    private Long id;
    private String name;
    private String email;
    private String password;


    public User getUserFromDto(){
        User user = new User();
        user.setId(this.getId());
        user.setEmail(this.getEmail());
        user.setPassword(this.getPassword());
        user.setName(this.getName());

        return user;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }
}
