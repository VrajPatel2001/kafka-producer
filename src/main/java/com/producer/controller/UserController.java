package com.producer.controller;

import com.producer.exception.DuplicateUserException;
import com.producer.kafka.Publisher;
import com.producer.model.User;
import com.producer.model.UserDto;
import com.producer.repository.UserRepository;
import com.producer.service.UserService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;


@RestController
public class UserController {

    @Autowired
    private Publisher publisher;

    @Autowired
    private UserService userService;

    @Autowired
    private UserRepository userRepository;


    private final Logger logger = LoggerFactory.getLogger(UserController.class);

    @PostMapping("/user")
    public ResponseEntity<String> createUser(@RequestBody UserDto user){
        logger.info("in User create");
        try {
            Optional<User> nUser = Optional.ofNullable(userService.save(user));
            if(nUser.isEmpty()){
                return ResponseEntity.internalServerError().body("Something went wrong");
            }
            publisher.userCreated(nUser.get());
            return ResponseEntity.ok("User Created");
        }
        catch (NullPointerException | DuplicateUserException i){
            return ResponseEntity.badRequest().body(i.getMessage());
        }

    }

    @GetMapping("/user/{id}")
    public ResponseEntity<Optional<User>> getUser(@PathVariable Long id){
        Optional<User> user = userRepository.findById(id);
        logger.info("------------------------------------ in get user --------------------------------");
        return ResponseEntity.ok(user);
    }
}
