package com.producer.controller;

import com.producer.kafka.Publisher;
import com.producer.model.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;


@RestController

public class UserController {

    @Autowired
    private Publisher publisher;

    @PostMapping("/user")
    public String CreateUser(@RequestBody UserDTO user){
        User user = new User(1,"Vraj","Vrajnp2001@gmail.com",6478693320L);
        publisher.UserCreated(user);
        return "Success";
    }
}
